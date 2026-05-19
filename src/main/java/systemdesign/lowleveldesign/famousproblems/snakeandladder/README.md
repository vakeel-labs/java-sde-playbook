# Snake and Ladder Game

Design a multiplayer Snake and Ladder board game.

## Functional Requirements
- Configurable board size (default 100 cells)
- Configurable number of snakes and ladders
- Multiple players (2-4)
- Dice roll moves player forward
- Landing on snake head → slide to snake tail
- Landing on ladder bottom → climb to ladder top
- First player to reach cell 100 wins

## Core Entities
- Game / GameController
- Board
- Cell
- Snake (head → tail positions)
- Ladder (start → end positions)
- Player
- Dice
- GameStatus (In Progress, Finished)

## Design Patterns Applied
- **Strategy**: DiceRollStrategy (fair dice, loaded dice for testing)
- **Observer**: Notify players of game events (snake bite, ladder climb, win)
- **Builder**: GameBuilder for configuring snakes, ladders, players
- **Template Method**: Game loop skeleton — roll dice, move, check special cell, check win
