public class Square
{
    private boolean dirty;

    private Square north, south, east, west = null;

    public Square(boolean dirty)
    {
        this.dirty = dirty;
    }

    public Square(boolean dirty, Square north, Square south, Square east, Square west)
    {
        this.dirty = dirty;

        this.north = north;

        this.south = south;

        this.east = east;

        this.west = west;
    }

    public boolean dirty()
    {
        return dirty;
    }

    public void changeState() //Actually changes the space from dirty to clean
    {
        if (dirty)
        {
            dirty = false;
        }
        else
        {
            dirty = true;
        }
    }

    public Square getNorth() //Getter for North Square
    {
        return north;
    }

    public void setNorth(Square north) //Setter for North Square
    {
        this.north = north;
    }

    public Square getSouth() //Getter for South Square
    {
        return south;
    }

    public void setSouth(Square south) //Setter for South Square
    {
        this.south = south;
    }

    public Square getEast() //Getter for East Square
    {
        return east;
    }

    public void setEast(Square east) //Setter for East Square
    {
        this.east = east;
    }

    public Square getWest() //Getter for West Square
    {
        return west;
    }

    public void setWest(Square west) //Setter for West Square
    {
        this.west = west;
    }

    public String toString()
    {
        if (dirty)
        {
            return "D";
        }
        else
        {
            return "C";
        }
    }
}