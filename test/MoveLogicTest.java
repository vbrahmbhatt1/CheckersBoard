import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MoveLogicTest {

	static MoveLogic move;
	
	@Before
	public void setUpBefore() throws Exception 
	{
		move = new MoveLogic();
	}
	
	
	@Test
	// test that a standard white piece can move one position. this is a legal move
	public void testBasicMoveWhite() 
	{
		move.setPlayerTurn(1);
		assertTrue("testBasicMoveWhite should pass", move.validateMove("A3", "B4"));
	}
	
	@Test
	// test that a standard red piece can move one position. this is a legal move
	public void testBasicMoveRed() 
	{
		move.setPlayerTurn(2);
		assertTrue("testBasicMoveRed should pass", move.validateMove("F6", "G5"));
	}

	@Test
	// test that a standard white piece cannot move 2 squares in one move
	public void testBasicMoveWhiteFail() 
	{
		move.setPlayerTurn(2);
		assertFalse("testBasicMoveWhiteFail should pass", move.validateMove("G3", "E5"));
	}
	
	@Test
	// test that a standard red piece cannot move 2 squares in one move
	public void testBasicMoveRedFail() 
	{
		move.setPlayerTurn(2);
		assertFalse("testBasicMoveRedFail should pass", move.validateMove("F6", "D4"));
	}
	
	@Test
	// test that a standard piece cannot move backwards
	public void testBackwardsMoveStandard() 
	{
		move.setPlayerTurn(1);
		move.validateMove("C3", "D4");
		assertFalse("testBackwardsMoveStandard should pass", move.validateMove("D4", "C3"));
	}
	
	@Test
	// test king can move backwards
	public void testKingMove() 
	{
		move.setPlayerTurn(1);
		move.buttonStatus.put("E3", "wKing");
		move.validateMove("E3", "D4");
		move.validateMove("H6", "G5");
		
		assertTrue("testKingMove should pass", move.validateMove("D4", "E3"));
	}
	
	@Test
	// test that jumpOpp identifies that a jump opportunity exists
	public void testJumpOpp() 
	{
		move.setPlayerTurn(1);
		move.validateMove("C3", "D4");
		move.validateMove("B6", "C5");
		assertTrue("jumoOpp should pass", move.jumpOpp("white"));
		assertTrue("testJumpOpp should pass", move.validateMove("D4", "B6"));
	}
	
	@Test
	// test that a piece can execute a legal jump. Checks the jumpOpp class
	public void testJump() 
	{
		move.setPlayerTurn(1);
		move.validateMove("G3", "F4");
		move.validateMove("H6", "G5");
		move.validateMove("F4", "E5");
		move.jumpOpp("red");
		assertTrue("testJump should pass", move.validateMove("F6", "D4"));
	}
	
	@Test
	// test that a player who has a jump must jump
	public void testMustJump() 
	{
		move.setPlayerTurn(1);
		move.validateMove("A3", "B4");
		move.validateMove("H6", "G5");
		move.validateMove("B4", "C5");
		move.jumpOpp("red");
		
		assertFalse("testMustJump should pass", move.validateMove("D6", "E5"));
	}
	
	@Test
	// test that the jumpCheck method validates that a specific square has a jump opp
	public void testJumpCheck() 
	{
		move.setPlayerTurn(1);
		move.validateMove("A3", "B4");
		move.validateMove("H6", "G5");
		move.validateMove("B4", "C5");
		move.jumpOpp("red");
		
		assertTrue("testJumpCheck should pass", move.jumpCheck("D6", "red"));
	}
	
	@Test
	// test find adjacent left
	public void testAjacentLeft() 
	{
		move.setPlayerTurn(1);
		move.validateMove("A3", "B4");
		move.validateMove("B6", "A5");
		String left = move.findLeftAdjacent("A5", "red");

		assertTrue("testAjacentLeft should pass", left.equals("B4"));
	}
	
	@Test
	// test find adjacent right
	public void testAjacentRight() 
	{
		move.setPlayerTurn(1);
		move.validateMove("G3", "F4");
		move.validateMove("H6", "G5");
		String right = move.findRightAdjacent("G5", "red");
		
		assertTrue("testAjacentLeft should pass", right.equals("F4"));
	}
	
	@Test
	// test set and get player turn
	public void testPlayerTurn() 
	{
		move.setPlayerTurn(1);
		int p = move.getPlayerTurn();
		
		assertTrue("testPlayerTurn should pass", p ==1);
	}
	

}

