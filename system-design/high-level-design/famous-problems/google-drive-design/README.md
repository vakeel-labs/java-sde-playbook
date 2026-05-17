# Google Drive (Cloud File Storage)

## Scale
1B users, 15GB free storage per user, file sharing and collaboration, sync across multiple devices

## Core Challenges
Block-level file storage and deduplication, cross-device sync protocol, conflict resolution, real-time collaboration

## APIs
- POST /files/upload { name, content, parent_folder_id } -> file_id (chunked upload supported)
- GET /files/{id}/download -> file content stream
- POST /files/{id}/share { email, permission } -> shareable link
- GET /files?folder_id=root -> list files and folders
- GET /changes?page_token=... -> delta changes since last sync (for client sync)

## Core Components
- **Upload Service** - Chunked file upload; content-addressable block storage; deduplication
- **Block Storage** - Files split into 4MB blocks; each block stored by SHA-256 hash; S3/GCS
- **Metadata Service** - File/folder hierarchy, ownership, permissions, block list per file version; PostgreSQL
- **Sync Service** - Detects file changes; pushes deltas to clients; WebSocket for real-time change notifications
- **Sharing Service** - Access control lists; shareable link generation; permission enforcement
- **CDN** - Caches popular/recently accessed files at edge nodes for fast download

## Deep Dive
- **Block-level storage**: File split into 4MB fixed-size blocks. Each block stored by SHA-256(content) as filename. File = ordered list of block hashes. On edit, only changed blocks uploaded (delta sync). Massively reduces upload bandwidth for minor edits.
- **Deduplication**: Two users uploading identical files store only one copy (same block hash). If all blocks already exist on server, upload is instant (zero-byte upload).
- **Sync protocol**: Client maintains local block hash state. On reconnect, calls GET /changes?page_token=last_token to get list of changed files since last sync. Client downloads only the changed blocks, not full files.
- **Conflict resolution**: Last-write-wins for most files. When simultaneous edit detected (same parent version, different content), create a "Conflict Copy" alongside the original. User manually resolves.

## Key Trade-offs
- Block size: smaller (1MB) = more granular delta sync but more metadata overhead; larger (10MB) = fewer metadata entries but coarser delta sync. 4MB is a common sweet spot.
- Sync frequency: real-time via WebSocket push vs polling every N seconds. WebSocket preferred for active users; polling fallback for background sync.
