import java.lang.Math;

public class Environment
{
    private Square floor[][];

    private Vacuum vacuum;

    private int x, y = 0;

    public Environment(Vacuum vacuum, int y, int x)
    {
        this.vacuum = vacuum;

        this.x = x;

        this.y = y;

        createFloorAndRandomlySetState();

        run();
    }

    public Environment(Vacuum vacuum, Square floor[][])
    {
        this.vacuum = vacuum;

        this.floor = floor;

        x = this.floor.length;

        y = this.floor[0].length;

        run();
    }

    private void run()
    {
        generateVacuumLocation();

        displayInitialFloor();

        cleanTheFloor();

        displayFinalSummary();
    }

    private void createFloorAndRandomlySetState() //Generates a floor with randomly places dirty squares
    {
        initializeFloor();

        generateSquares();

        linkSquaresAndRandomlySetDirty();
    }

    private void initializeFloor()
    {
        floor = new Square[x][y];
    }

    private void generateSquares()
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                floor[i][j] = new Square(false);
            }
        }
    }

    private void linkSquaresAndRandomlySetDirty()
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                linkEastWestSquares(i, j);

                linkNorthWestSquares(i, j);

                randomlyChangeState(i, j);
            }
        }
    }

    private void linkEastWestSquares(int i, int j)
    {
        if (i > 0 && x > 1)
        {
            floor[i - 1][j].setEast(floor[i][j]);

            floor[i][j].setWest(floor[i - 1][j]);
        }
    }

    private void linkNorthWestSquares(int i, int j)
    {
        if (j > 0 && y > 1)
        {
            floor[i][j - 1].setSouth(floor[i][j]);

            floor[i][j].setNorth(floor[i][j - 1]);
        }
    }

    private void randomlyChangeState(int i, int j)
    {
        if (randomlyChangeState())
        {
            floor[i][j].changeState( );
        }
    }

    private boolean randomlyChangeState()
    {
        return (Math.random() > .5);
    }

    private void generateVacuumLocation() //Generates a random location for the vacuum to start
    {
        int randX;
        int randY;

        do
        {
            randX = (int) (Math.random( ) * x);

            randY = (int) (Math.random( ) * y);
        }
        while (floor[randX][randY] == null);
        {
            vacuum.setLocation(floor[randX][randY]);
        }
    }

    private void displayInitialFloor() //Displays the initial layout of the floor before the vacuum runs
    {
        System.out.println("Initial");
        System.out.print(" ");
        for (int i = 0; i < y; i++)
        {
            System.out.print("---");
        }
        System.out.println();

        displayFloor();

        System.out.print(" ");
        for (int i = 0; i < y; i++)
        {
            System.out.print("---");
        }
        System.out.println();
        System.out.println();
    }

    private void cleanTheFloor() //Checks to see if the floor is clean, if not then it executes cleanAndMoveVacuum()
    {
        while (!checkIfFloorIsClean())
        {
            cleanAndMoveVacuum( );
        }
    }

    private void cleanAndMoveVacuum() //Cleans the space and moves the vacuum
    {
        vacuum.suck();

        vacuum.move();
    }

    private void displayFinalSummary() //Displays the final floor after the vacuum runs and the summary of the clean
    {
        System.out.println("Final");
        System.out.print(" ");
        for (int i = 0; i < y; i++)
        {
            System.out.print("---");
        }
        System.out.println();

        displayFloor();

        System.out.print(" ");
        for (int i = 0; i < y; i++)
        {
            System.out.print("---");
        }
        System.out.println();

        System.out.println("\nThe vacuum moved: " + vacuum.getMoves() + " times");

        System.out.println("The vacuum sucked: " + vacuum.getNumSuck() + " times\n");

    }

    private void displayFloor() //Displays the contents of the floor
    {
        for (int i = 0; i < x; i++)
        {
            System.out.print("|");
            for (int j = 0; j < y; j++)
            {
                printFloorPiece(i, j);
            }
            System.out.println("|");
        }
    }

    private void printFloorPiece(int i, int j) //Prints each individual space of the floor
    {
        if (floor[i][j] == null)
        {
            System.out.print(" N ");
        }
        else
        {
            System.out.print(" " + floor[i][j] + " ");
        }
    }

    private boolean checkIfFloorIsClean() //Checks to see if floor is clean
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (!checkIfFloorPieceIsClean(i, j))
                {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkIfFloorPieceIsClean(int i, int j) //Checks to see if floor is clean at specific location
    {
        try
        {
            if (floor[i][j].dirty())
            {
                return false;
            }
        }
        catch (Exception e)
        {
        }

        return true;
    }
}