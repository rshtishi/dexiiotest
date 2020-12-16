package com.github.rshtishi.dexiiotest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.javatuples.Pair;

public class Maze {
	
	private static final int ENTRY = 1;
	private static final int WALL  = 0;
	private static final int N = 4;
	private static final int M = 6;
	
	private int[][] mazeArray = {
			{0, 0, 0, 1, 0, 0},
			{0, 0, 1, 1, 1, 0},
			{0, 0, 1, 1, 0, 0},
			{0, 0, 0, 1, 0, 0}
	};
	
	private Stack<Pair<Integer,Integer>> path = new Stack<>();
	
	public List<Pair<Integer,Integer>> findEntryPoints(){
		List<Pair<Integer,Integer>> entryPoints = new ArrayList<>();
		for(int i=0; i < mazeArray[0].length;i++) {
			if(mazeArray[0][i]==ENTRY) {
				entryPoints.add(new Pair<>(0,i));
			}
		}
		return entryPoints;	
	}

	public boolean buildPath(int x, int y) {
		//base case
		if(x==N-1 && mazeArray[x][y]==1) {
			path.add(new Pair<>(x, y));
			return true;
		}
		
		if(x >= 0 && x<N && y>=0 && y<M && mazeArray[x][y]==ENTRY) {
			path.add(new Pair<>(x, y));
			
			// move straight
			if (buildPath(x + 1, y)==true) {
				return true;
			}
			//move right
			if (buildPath(x, y+1)==true) {
				return true;
			}
			//move left
			if (buildPath(x, y-1)==true) {
				return true;
			}
			//backtrack
			path.pop();
			return false;
		}
		
		return false;
	}
	
	public boolean solveMaze() {
		List<Pair<Integer,Integer>> entrypoints = findEntryPoints();
		for(Pair<Integer, Integer> entrypoint : entrypoints) {
			if(buildPath(entrypoint.getValue0(),entrypoint.getValue1())) {
				return true;
			}
		}
		return false;
	}

	public Stack<Pair<Integer, Integer>> getPath() {
		return path;
	}

}
