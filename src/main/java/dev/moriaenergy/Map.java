package dev.moriaenergy;

public class Map {
    private final int H, W;
    final Cell[][] array;

    public Map( int H, int W  ){ // Mettre les infos des levels dedans ou dans une class à part ?
        this.H = H;
        this.W = W;
        this.array = new Cell[H][W];
    }

    void updateWifi() {
        boolean enabled = false;
        for(Cell[] cells : array)
            for(Cell cell : cells)
                if( cell != null && cell.tile == Tile.W
                            && cell.seekPower( this ) ) {
                    enabled = true;
                    break;
                }
        for(Cell[] cells : array)
            for(Cell cell : cells)
                if(cell != null && cell.tile == Tile.W)
                    cell.setEnabled( this, enabled );
    }

    public int getW(){return this.W;}

    public int getH(){return this.H;}

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < getW() && y >= 0 && y < getH();
    }

}