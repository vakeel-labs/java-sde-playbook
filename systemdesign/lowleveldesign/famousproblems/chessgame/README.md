# Chess Game

Design a two-player chess game with all standard rules.

## Functional Requirements
- Two players (Human vs Human or Human vs AI)
- Standard chess board (8x8)
- All piece types: King, Queen, Rook, Bishop, Knight, Pawn
- Legal move validation for each piece type
- Special moves: castling, en passant, pawn promotion
- Check, Checkmate, Stalemate detection
- Move history and undo capability

## Core Entities
- Game / GameController
- Board (8x8 grid of Cells)
- Cell (row, col, optional Piece)
- Piece (abstract: King, Queen, Rook, Bishop, Knight, Pawn)
- Player (Human, AIPlayer)
- Move (source cell, destination cell, captured piece)
- MoveValidator
- MoveHistory (for undo)

## Design Patterns Applied
- **Strategy**: MoveStrategy per piece type; AI move selection strategy
- **Command**: Each Move is a Command enabling undo via MoveHistory (Memento-like)
- **Observer**: Notify UI of board state changes
- **Factory**: PieceFactory for creating pieces from notation
