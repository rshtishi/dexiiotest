package com.github.rshtishi.dexiiotest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

import org.javatuples.Pair;
import org.junit.Test;

public class MazeTest {


	Maze maze = new Maze();

	@Test
	public void testFindEntryPoints() {
		List<Pair<Integer, Integer>> entrypoints = maze.findEntryPoints();
		assertEquals(1, entrypoints.size());
		assertEquals(0, entrypoints.get(0).getValue0().intValue());
		assertEquals(3, entrypoints.get(0).getValue1().intValue());
	}
	
	@Test
	public void testBuildPath() {
		Stack<Pair<Integer,Integer>> expectedStack = new Stack<>();
		expectedStack.push(new Pair<>(0,3));
		expectedStack.push(new Pair<>(1,3));
		expectedStack.push(new Pair<>(2,3));
		expectedStack.push(new Pair<>(3,3));
		boolean result = maze.buildPath(0, 3);
		assertTrue(result);
		maze.getPath().forEach(pair ->{
			System.out.println(pair.getValue0()+" "+pair.getValue1());
		});
		assertEquals(expectedStack, maze.getPath());
	}
	
	@Test
	public void testSolveMaze() {
		Stack<Pair<Integer,Integer>> expectedStack = new Stack<>();
		expectedStack.push(new Pair<>(0,3));
		expectedStack.push(new Pair<>(1,3));
		expectedStack.push(new Pair<>(2,3));
		expectedStack.push(new Pair<>(3,3));
		boolean result = maze.solveMaze();
		assertTrue(result);
		assertEquals(expectedStack, maze.getPath());
	}


}
