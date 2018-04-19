package Problems.robot_world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WorldMapReader {

	// The dimensions of the world map
	private int maxRows, maxColumns;

	// Positional information for the robot and the goal
	private int initRobotRow, initRobotColumn;
	private int goalRow, goalColumn;

	// All the interesting stuff happens in readWorldMap
	public WorldMapReader() {
	}

	// Primary method of this class

	public char[][] readWorldMap(String mapFileName) throws IOException {

		File mapFile = new File(mapFileName);

		if (!mapFile.exists()) {
			throw new IOException("File does not exist!!!");
		}
		if (!mapFile.isFile()) {
			throw new IOException("Not a valid file!!!");
		}

		BufferedReader reader = new BufferedReader(new FileReader(mapFile));

		maxRows = 0;
		maxColumns = 0;
		int currColumn = 0;

		// This simply finds the dimensions of the map, without
		// reading the chars into the array
		while (true) {
			int ch = reader.read();
			if (ch == -1) {
				break;
			}

			switch (ch) {
			case '\r':
				break; // ignore
			case '\n':
				maxRows++;
				if (currColumn > maxColumns) {
					maxColumns = currColumn;
				}
				currColumn = 0;
				break;
			default:
				currColumn++;
				break;
			}
		}

		reader.close();

		// Now, initialize the map to the proper dimensions
		char[][] worldMap = new char[maxRows][maxColumns];

		// Now, create a new reader, and store the proper chars to the
		// character array

		reader = new BufferedReader(new FileReader(mapFile));
		initRobotColumn = -1;
		initRobotRow = -1;
		goalColumn = -1;
		goalRow = -1;
		int col = 0, row = 0;

		while (true) {
			int ch = reader.read();

			if (ch == -1) {
				break;
			}

			switch (ch) {

			case '\r':
				break; // ignore

			case '\n':
				row++;
				col = 0;
				break;

			case RobotWorld.SPACE:
				worldMap[row][col] = RobotWorld.SPACE;
				col++;
				break;

			case RobotWorld.WALL:
				worldMap[row][col] = RobotWorld.WALL;
				col++;
				break;

			case RobotWorld.GOAL:
				if (goalColumn != -1 || goalRow != -1) {
					throw new IOException("Cannot have multiple goals!");
				}
				goalColumn = col;
				goalRow = row;
				worldMap[row][col] = RobotWorld.GOAL;
				col++;
				break;

			case RobotWorld.NORTH:
			case RobotWorld.SOUTH:
			case RobotWorld.EAST:
			case RobotWorld.WEST:
				if (initRobotColumn != -1 || initRobotRow != -1) {
					throw new IOException("Cannot have multiple robots!");
				}
				initRobotColumn = col;
				initRobotRow = row;
				worldMap[row][col] = (char) ch;
				col++;
				break;

			default:
				throw new IOException("Cannot have character '" + (char) ch + "' in map file.");
			}
		}
		
		reader.close();

		if (initRobotColumn == -1 || initRobotRow == -1) {
			throw new IOException("Map file must contain a robot");
		}

		if (goalColumn == -1 || goalRow == -1) {
			throw new IOException("Map file must contain a goal");
		}

		return worldMap;

	}

	// Getters

	public int getMaxRows() {
		return maxRows;
	}

	public int getMaxColumns() {
		return maxColumns;
	}

	public int getInitRobotRow() {
		return initRobotRow;
	}

	public int getInitRobotColumn() {
		return initRobotColumn;
	}

	public int getGoalRow() {
		return goalRow;
	}

	public int getGoalColumn() {
		return goalColumn;
	}
}
