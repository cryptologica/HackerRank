#!/bin/python

from copy import deepcopy

'''
https://www.hackerrank.com/challenges/hip
@author: Sean & JT
'''

# Head ends here
def nextMove(player, board):
    numRemaining = getNumbLegalMoves(board)
    if numRemaining > 20:
        depth = 0
    elif numRemaining > 7:
        depth = 0.5
    elif numRemaining > 4:
        depth = 1
    else:
        depth = 1.5
    
    
    children = getLegalMoves(board)
    
    if player == 'b':
        bestScoreFound = -2
        for (i,j) in children:
            newBoard = deepcopy(board)
            newBoard[i] = newBoard[i][:j] + 'b' + newBoard[i][j+1:]
            score = __nextMove('r', newBoard, depth, -2, 2)
            if score > bestScoreFound:
                bestScoreFound = score
                bestMove = i,j
    else:
        bestScoreFound = 2
        for (i,j) in children:
            newBoard = deepcopy(board)
            newBoard[i] = newBoard[i][:j] + 'r' + newBoard[i][j+1:]
            score = __nextMove('b', newBoard, depth, -2, 2)
            if score < bestScoreFound:
                bestScoreFound = score
                bestMove = i,j
                
    return bestMove

def __nextMove(player, board, depthToCompute, alpha, beta):
    if depthToCompute <= 0:
        return evaluatePosition(board, player)
    if checkLost('b', board):
        return -1
    if checkLost('r', board):
        return 1
    
    children = getLegalMoves(board)
    
    if player == 'b':
        for (i,j) in children:
            newBoard = deepcopy(board)
            newBoard[i] = newBoard[i][:j] + 'b' + newBoard[i][j+1:]
            score = __nextMove('r', newBoard, depthToCompute - 0.5, alpha, beta)
            if score > alpha:
                alpha = score
            if alpha >= beta:
                return alpha
        return alpha
    else:
        for (i,j) in children:
            newBoard = deepcopy(board)
            newBoard[i] = newBoard[i][:j] + 'r' + newBoard[i][j+1:]
            score = __nextMove('b', newBoard, depthToCompute - 0.5, alpha, beta)
            if score < beta:
                beta = score
            if alpha >= beta:
                return beta
        return beta

def evaluatePosition(board, playerToMove):
    if checkLost('b', board):
        return -1
    if checkLost('r', board):
        return 1
    numbBlue = getNumbNonlosingMoves('b', board)
    numbRed = getNumbNonlosingMoves('r', board)
    numerator = 0.0 + numbBlue - numbRed
    denominator = 0.0 + numbBlue + numbRed
    if denominator == 0:
        if playerToMove == 'b':
            return -1
        else:
            return 1
    score = numerator / denominator
    return score

#Returns a list of legal actions for the board
def getLegalMoves(board):
    moves = list()
    for i in range(0,9):
        for j in range(0,9):
            if board[i][j] == '-':
                moves.append((i,j))
    return moves

def getNumbNonlosingMoves(player, board):
    moves = getLegalMoves(board)
    nonlosingMoves = 0
    for (i, j) in moves:
        newBoard = deepcopy(board)
        newBoard[i] = newBoard[i][:j] + player + newBoard[i][j+1:]
        if not checkLost(player, newBoard):
            nonlosingMoves += 1
    return nonlosingMoves

def getNumbLegalMoves(board):
    num = 0
    for i in range(0,9):
        for j in range(0,9):
            if board[i][j] == '-':
                num += 1
    return num
                
"Returns true if the specified player has lost (formed a square) that is at the given tilt"
def __checkLostAtTilt(player, board, tilt):
    for i in range(8, tilt, -1):
        for j in range(0, 9):
            if board[i][j] == player:
                for k in range(j+1, 9):
                    if player == board[i-tilt][k]:
                        length = k - j
                        if i - (length + tilt) >= 0:
                            if j - tilt >= 0:
                                if board[i - length][j - tilt] == player:
                                    if board[i - (length + tilt)][k - tilt] == player:
                                        #print("Loop 1")
                                        #print("Coordinates of i, j: " + str(i) + " " + str(j))
                                        return True
                for k in range(0, j):
                    if player == board[i-tilt][k]:
                        length = j - k
                        if i - (length + tilt) >= 0:
                            if j + tilt <= 8:
                                if board[i - length][j + tilt] == player:
                                    if board[i - (length + tilt)][k + tilt] == player:
                                        #print("Loop 2")
                                        #print("Coordinates of i, j: " + str(i) + " " + str(j))
                                        return True
    return False

# Returns true if the specified player lost on this board
def checkLost(player, board):
    for i in range(0,8):
        if __checkLostAtTilt(player, board, i):
            #print("Lost at tilt " + str(i))
            return True
    return False

# Tail starts here
player = raw_input()

board = []
for i in xrange(0, 9):
    board.append(raw_input())
a,b = nextMove(player,board)
print a,b
