package com.bossbaby.game;

public class Maze {
	private int height;
    private int width;
    private boolean [][] hasDots;
	private String[] MAP = new String [] {
            "ttttgggggggggggggggggggttttttttg",
            "gtttgtgggggwwwwwwwwwwggggggggggg",
            "ggtttgtggwwwwww......wwwgtttsttg",
            "gwwwwwwwwwwwww.ppppp..wwwww.p.ww",
            "wwwwwwwwwwwww.pppp.ppp.www.pp..w",
            "......wwwwwww.ppp.w.ppp.ww.pp..w",
            "ppppp.wwwwwww.pp.ww.ppp.ww.pp.wg",
            "pppppp........pp.www.pp.ww.pp.wg",
            "...ppppppppppppp.www.ppp..ppp.wg",
            "www.pppppppppppp.wwww.pppppp.wwg",
            "wwww....pp....w.wwwwww.ppppp.wwg",
            "ttgwwwww..wwwwwwwwwwwww.....wggg",
            "tttttwwwwwwwttttttttttwwwwwgtttt",
            "00000000000001230C00000000000000",
            "00000000000004560000000000000000",
            "00000000000000000000000000000000",
            
    };
	
	private void initDotData() {
        hasDots = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                hasDots[r][c] = MAP[r].charAt(c) == 'p';
            }
        }
    }
	public boolean hasDotAt(int r, int c) {
		return hasDots[r][c];
	    }
	public void removeDotAt(int r, int c) {
        hasDots[r][c] = false;
    }

    public Maze() {
        height = MAP.length;
        width = MAP[0].length();
        //initDotData();
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean hasWaterAt(int r, int c) {
        return MAP[r].charAt(c) == 'p';
    }
    public boolean hasSandAt(int r, int c) {
        return MAP[r].charAt(c) == '.';
    }
    public boolean hasBlockAt(int r, int c) {
        return MAP[r].charAt(c) == '0';
    }
    public boolean hasCoinAt(int r, int c) {
        return MAP[r].charAt(c) == 'C';
    }
    public boolean hasKol_butAt(int r, int c) {
        return MAP[r].charAt(c) == '1';
    }
    public boolean hasBomb_butAt(int r, int c) {
        return MAP[r].charAt(c) == '2';
    }
    public boolean hasFreez_butAt(int r, int c) {
        return MAP[r].charAt(c) == '3';
    }
    public boolean hasKol_priceAt(int r, int c) {
        return MAP[r].charAt(c) == '4';
    }
    public boolean hasBomb_priceAt(int r, int c) {
        return MAP[r].charAt(c) == '5';
    }
    public boolean hasFreez_priceAt(int r, int c) {
        return MAP[r].charAt(c) == '6';
    }
    public boolean hasArea_weaponAt(int r, int c) {
        return MAP[r].charAt(c) == 'w';
    }
    public boolean hasTreeAt(int r, int c) {
        return MAP[r].charAt(c) == 't';
    }
    public boolean hasGrassAt(int r, int c) {
        return MAP[r].charAt(c) == 'g';
    }
    public boolean hasCastleAt(int r, int c) {
        return MAP[r].charAt(c) == 's';
    }
 
 //   public boolean hasDotAt(int r, int c) {
  ////      return MAP[r].charAt(c) == '.';
  //  }

}
