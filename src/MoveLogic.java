/*
 * MoveLogic is a class that controls the checkers game. It maintains a map of all squares and the current color.
 * It receives information from CheckersBoardFlowLayout, validates moves and passes back results.
 */


import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;


public class MoveLogic
{

    String w = "white";
    String r = "red";
    String b = "black";
    String wk = "wKing";
    String rk = "rKing";
    int whiteCount = 0;
    int redCount = 0;

    // buttonStatus is the map that maintains the list of squares and current color
    static HashMap<String, String> buttonStatus;
    int player;
    boolean jumOppIndicator = false;
    boolean king = false;

    public MoveLogic ()
    {

        buttonStatus = new HashMap<String, String>();

        // declare white pieces for start of game
        buttonStatus.put("A1", w);
        buttonStatus.put("C1", w);
        buttonStatus.put("E1", w);
        buttonStatus.put("G1", w);
        buttonStatus.put("B2", w);
        buttonStatus.put("D2", w);
        buttonStatus.put("F2", w);
        buttonStatus.put("H2", w);
        buttonStatus.put("A3", w);
        buttonStatus.put("C3", w);
        buttonStatus.put("E3", w);
        buttonStatus.put("G3", w);
        whiteCount = 12;
        
        //declare empty spaces
        buttonStatus.put("B4", b);
        buttonStatus.put("D4", b);
        buttonStatus.put("F4", b);
        buttonStatus.put("H4", b);
        buttonStatus.put("A5", b);
        buttonStatus.put("C5", b);
        buttonStatus.put("E5", b);
        buttonStatus.put("G5", b);

        //declare red pieces
        buttonStatus.put("B6", r);
        buttonStatus.put("D6", r);
        buttonStatus.put("F6", r);
        buttonStatus.put("H6", r);
        buttonStatus.put("A7", r);
        buttonStatus.put("C7", r);
        buttonStatus.put("E7", r);
        buttonStatus.put("G7", r);
        buttonStatus.put("B8", r);
        buttonStatus.put("D8", r);
        buttonStatus.put("F8", r);
        buttonStatus.put("H8", r);
        
        redCount = 12;
        
    }

    // method that returns the current map of square status
    public HashMap<String, String> getButtonStatus()
    {

        return buttonStatus;
    }

    // method that validates a move. it takes in the square the pieces is moves from and the square the user wants to move to
    public boolean validateMove(String fromSquare, String toSquare)
    {
        String from = fromSquare;
        String to = toSquare;
        String fromColor = buttonStatus.get(from);

        // get the column Letters and row numbers as a string values
        String fromColumn = String.valueOf(from.charAt(0));
        String fromRow = String.valueOf(from.charAt(1));
        String toColumn = String.valueOf(to.charAt(0));
        String toRow = String.valueOf(to.charAt(1));

        // change columns and rows to integers for calculations. Absolute values are uses for Kings
        int fromRowInt = Integer.parseInt(fromRow);
        int toRowInt = Integer.parseInt(toRow);
        int moveRowCount = fromRowInt - toRowInt;
        int moveRowCountAbs = Math.abs((fromRowInt - toRowInt));
        int fromColInt = columnNumber(fromColumn);
        int toColInt = columnNumber(toColumn);
        int moveColCount = Math.abs((fromColInt - toColInt));

        // identify if the square is currently a king or if last move was the opposite side, make it king.
        if ((fromColor == "wKing") || (fromColor == "white" && fromRowInt == 8))
        {
            king = true;
        }
        else if ((fromColor == "rKing") || (fromColor == "red" && fromRowInt == 1))
        {
            king = true;
        }

        //check to see if the move is more than 2 rows. If so, move is invalid
        if (moveRowCountAbs > 2)
        {
            return false;
        }
        // moves of two rows are for jumping.
        if (moveRowCountAbs == 2)
        {
            //confirm player has a jump opportunity
            if (jumOppIndicator == false)
            {
                return false;
            }
            // validate jump move
            int jumpDirection = fromColInt - toColInt;

            // jump direction is less than zero is a jump to the left when looking at the board.
            // for example, column A=1 and B=2. A move from A to B is 1-2=-1.
            if (jumpDirection < 0)
            {
                // call adjacent findLeftAdjacentSquare method to identify the adjacent square to the left of the move from square
                String jumpSquare = findLeftAdjacent(fromSquare, fromColor);

                // if the adjacent square is populated with the same color piece, a jump is not possible
                if (buttonStatus.get(jumpSquare) == fromColor)
                {
                    return false;
                }

                // find the square Adjacent to the jump square. this is where the jumping piece will land.
                String targetSquare = findLeftAdjacent(jumpSquare, fromColor);

                // if the target square matches the moveTo square entered by the user, the jump is valid
                if (targetSquare.equals(toSquare))
                {
                    // update the map to move the piece
                    buttonStatus.put(from, b);
                    buttonStatus.put(to, fromColor);
                   
                    // remove the piece that was jumped 
                    buttonStatus.put(jumpSquare, b);
                    
                    // check to see if game is over
                    if (fromColor.equals("white") || fromColor.equals("wKing")) 
                    {
                    	redCount = redCount - 1;
                    }
                    if (fromColor.equals("red") || fromColor.equals("rKing"))
                    {
                    	whiteCount = whiteCount - 1;
                    }

                    // check to see if the user has another jump opportunity within the same turn
                    if (jumpOpp(fromColor) == true)
                    {
                        if (jumpCheck(targetSquare, fromColor) == true)
                        {
                            jumOppIndicator = true;
                            return true;
                        }
                        else jumOppIndicator = false;
                    }
                    else jumOppIndicator = false;
                }
            }
            // same as above but for a jump to the right
            if (jumpDirection > 0)
            {
            	String jumpSquare = findRightAdjacent(fromSquare, fromColor);
                if (buttonStatus.get(jumpSquare) == fromColor) {
                    return false;
                }
                String targetSquare = findRightAdjacent(jumpSquare, fromColor);
                if (targetSquare.equals(toSquare))
                {
                    buttonStatus.put(from, b);
                    buttonStatus.put(to, fromColor);
                    
                    // remove the piece that was jumped 
                    buttonStatus.put(jumpSquare, b);
                    
                    // check to see if game is over
                    if (fromColor.equals("white") || fromColor.equals("wKing")) 
                    {
                    	redCount = redCount - 1;
                    }
                    if (fromColor.equals("red") || fromColor.equals("rKing"))
                    {
                    	whiteCount = whiteCount - 1;
                    }
                    
                 // check to see if the user has another jump opportunity within the same turn
                    if (jumpOpp(fromColor) == true)
                    {
                        if (jumpCheck(targetSquare, fromColor) == true)
                        {
                            jumOppIndicator = true;
                            return true;
                        }
                        else jumOppIndicator = false;
                    }
                    else jumOppIndicator = false;
                }
            }

            // after valid move, change the player turn
            if (getPlayerTurn() == 1)
            {
                setPlayerTurn(2);
                king = false;
                return true;
            }
            else if (getPlayerTurn() == 2)
            {
                setPlayerTurn(1);
                king = false;
                return true;
            }
            else
                return false;
        }

        // check to see if move is only 1 space. it so it is valid. However a king can move in both directions.
        if (moveColCount == 1 && king == true)
        {
            if (jumOppIndicator == true)
            {
                return false; // user must jump
            }

            buttonStatus.put(from, b);
            buttonStatus.put(to, fromColor);

            // after valid move, change the player turn
            if (getPlayerTurn() == 1)
            {
                setPlayerTurn(2);
                king = false;
                return true;
            }
            else if (getPlayerTurn() == 2)
            {
                setPlayerTurn(1);
                king = false;
                return true;
            }
            else
                return false;
        }

        // check to see if move is only 1 space. it so it is valid. However a non-king can only move in one direction.
        if (moveColCount == 1 && king == false)
        {

            if (jumOppIndicator == true)
            {
                return false; // user must jump
            }

            // check to see that the intended move is in the right direction by color.
            // a red move is a positive move. for example, from row 8 to row 7 (8-7=1).
            // a white move is a negative move . for example, from row 1 to row 2 (1-2=-1)
            if (((moveRowCount > 0 && fromColor == "red" ) || (moveRowCount > 0 && fromColor == "rKing" ))
                    || ((moveRowCount < 0 && fromColor == "white") || (moveRowCount < 0 && fromColor == "wKing")))
            {
                // if the move is valid, update the map to move the piece
                buttonStatus.put(from, b);
                buttonStatus.put(to, fromColor);
            }
            else return false;

            // after valid move, change the player turn
            if (getPlayerTurn() == 1)
            {
                setPlayerTurn(2);
                king = false;
                return true;
            }
            else if (getPlayerTurn() == 2)
            {
                setPlayerTurn(1);
                king = false;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    // this method checks to see if a jump opportunity exists for a player based on color.
    // if a jump opportunity does exit, true is returned and the player is notified that they must jump
    public boolean jumpOpp (String color)
    {
        String plColor = color;
        String oppColor = b;
        String plKingColor = b;
        String oppKingColor = b;

        if (color == "white")
        {
            // define the current player and opposing player based on current color
            plColor = w;
            plKingColor = wk;
            oppColor = r;
            oppKingColor = rk;
        }
        else if (color == "red")
        {
            plColor = r;
            plKingColor = rk;
            oppColor = w;
            oppKingColor = wk;
        }

        // loop through buttonStatus to find spaces that match the current player color
        // and identify if any Adjacent squares are populated by an opposing color (i.e. does a jump opportunity exist)
        Set<Entry<String,String>> getId = buttonStatus.entrySet();
        for (Entry<String, String> s : getId)
        {
            String key = s.getKey();
            String buttonColor = buttonStatus.get(key);

            if (buttonColor == plColor || buttonColor == plKingColor)
            {
                // find Adjacent squares and get their colors
                String leftAdjacent = findLeftAdjacent(key, buttonColor);
                String rightAdjacent = findRightAdjacent(key, buttonColor);
                String colNextLeftColor = buttonStatus.get(leftAdjacent);
                String colNextRightColor = buttonStatus.get(rightAdjacent);

                // if an adjacent square is the opposing color, check the next square to see if it is open
                // if the square on the other size of an opposing color is open, a jump opportunity exists
                if (colNextLeftColor == oppColor || colNextLeftColor == oppKingColor)
                {
                    String jumpTargetLeft = findLeftAdjacent(leftAdjacent, buttonColor);
                    if (buttonStatus.get(jumpTargetLeft) == "black")
                    {
                        jumOppIndicator = true;
                        return true;
                    }
                }
                // same as above, but for the right side
                if (colNextRightColor == oppColor || colNextRightColor == oppKingColor)
                {
                    String jumpTargetRight = findRightAdjacent(rightAdjacent, buttonColor);
                    if (buttonStatus.get(jumpTargetRight) == "black")
                    {
                        jumOppIndicator = true;
                        return true;
                    }

                }

            }
        }

        return false;
    }

	/* method checks to see if an individual square has a jump opportunity.
	 * takes in a square and current color. returns a boolean. This is used in multiple jump situations.
	 */

    public boolean jumpCheck (String square, String color)
    {

        String fromSquare = square;
        String fromColor = color;
        String oppColor = b;
        String oppKingColor = b;

        // find adjacent squares
        String leftAdjacent = findLeftAdjacent(fromSquare, fromColor);
        String rightAdjacent = findRightAdjacent(fromSquare, fromColor);

        // colors of the current placer and opposing player
        if (fromColor == "red" || fromColor == "rKing")
        {
            oppColor = "white";
            oppKingColor = "wKing";
        }
        if (fromColor == "white" || fromColor == "wKing")
        {
            oppColor = "red";
            oppKingColor = "rKing";
        }
        // if an adjacent square matches the opponent color, an opportunity may exist
        if ((buttonStatus.get(leftAdjacent) == oppColor) || (buttonStatus.get(leftAdjacent) == oppKingColor))
        {
            // check the next square to see if it is open. if so a jump opportunity exists
            String targetSquare = findLeftAdjacent(leftAdjacent, fromColor);
            if (buttonStatus.get(targetSquare) == "black")
                return true;
        }
        // same as above but for the right size
        if ((buttonStatus.get(rightAdjacent) == oppColor) || (buttonStatus.get(leftAdjacent) == oppKingColor))
        {
            String targetSquare = findRightAdjacent(rightAdjacent, fromColor);
            if (buttonStatus.get(targetSquare) == "black")
                return true;
        }

        return false;

    }

    // takes in square and color and finds adjacent square to the left.
    public String findLeftAdjacent (String s, String c) {

        String square = s;
        String color = c;
        int nextRowInt = 0;
        String fromCol = String.valueOf(square.charAt(0));
        String fromRw = String.valueOf(square.charAt(1));
        int fromColInt = columnNumber(fromCol);
        int fromRwInt = Integer.parseInt(fromRw);
        if (color == "white" || color == "wKing")
        {
            nextRowInt = fromRwInt + 1;
        }
        if (color == "red" || color == "rKing")
        {
            nextRowInt = fromRwInt - 1;
        }
        String nextRow = Integer.toString(nextRowInt);
        int colNextLeftInt = fromColInt + 1;
        String colNextLeft = columnLetter(colNextLeftInt);
        colNextLeft = colNextLeft + nextRow;
        return colNextLeft;
    }

    // takes in square and color and finds adjacent square to the left.
    public String findRightAdjacent (String s, String c)
    {

        String square = s;
        String color = c;
        int nextRowInt = 0;
        String fromCol = String.valueOf(square.charAt(0));
        String fromRw = String.valueOf(square.charAt(1));
        int fromColInt = columnNumber(fromCol);
        int fromRwInt = Integer.parseInt(fromRw);
        if (color == "white" || color == "wKing")
        {
            nextRowInt = fromRwInt + 1;
        }
        if (color == "red" || color == "rKing")
        {
            nextRowInt = fromRwInt - 1;
        }
        String nextRow = Integer.toString(nextRowInt);
        int colNextRightInt = fromColInt - 1;
        String colNextRight = columnLetter(colNextRightInt);
        colNextRight = colNextRight + nextRow;
        return colNextRight;
       
    }

    // method converts a column letter to a number
    public int columnNumber (String c)
    {

        String column = c;

        if (column.equals("A"))
            return 1;
        if (column.equals("B"))
            return 2;
        if (column.equals("C"))
            return 3;
        if (column.equals("D"))
            return 4;
        if (column.equals("E"))
            return 5;
        if (column.equals("F"))
            return 6;
        if (column.equals("G"))
            return 7;
        if (column.equals("H"))
            return 8;
        else return 0;
    }

    // method converts a column number back to a letter
    public String columnLetter (int i)
    {

        int col = i;

        if (col == 1)
            return "A";
        if (col == 2)
            return "B";
        if (col == 3)
            return "C";
        if (col == 4)
            return "D";
        if (col == 5)
            return "E";
        if (col == 6)
            return "F";
        if (col == 7)
            return "G";
        if (col == 8)
            return "H";
        else return "Z";
    }

    // method sets the current player
    public void setPlayerTurn (int n)
    {

        player = n;
    }

    // method returns the current player
    public int getPlayerTurn()
    {

        return player;
    }
    
 // method returns the current piece count
    public int getPieceCount(String color)
    {
    	if (color == "white")
    		return whiteCount;
    	if (color == "red")
    		return redCount;
    	else return 0;
    }
}
