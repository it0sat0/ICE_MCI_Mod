package com.ice.mci_mod;

import java.io.*;

public class OpenChest {
    //配列で、各レベルの選択
    public static String LevNum[] = {"1", "2", "6", "8", "11", "00"};
    public static int Lev = LevNum.length - 1;
    public static int OpenChestPosition(String level, double x, double z, double LowLevel[][][], double HighLevel[][][], boolean LC) {

        if(LC==true){
            for(int j=0; j<2; j++) {
                for (int i = 0; i < 2; i++) {
                    if (LowLevel[j][i][0] - 5.0 <= x && x <= LowLevel[j][i][0] + 5.0) {
                        if (LowLevel[j][i][1] - 5 <= z && z <= LowLevel[j][i][1] + 5) {
                            Lev = j;
                        }
                    }
                }
            }
            for(int j=0; j<3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (HighLevel[j][i][0] - 5 <= x && x <= HighLevel[j][i][0] + 5) {
                        if (HighLevel[j][i][1] - 5 <= z && z <= HighLevel[j][i][1] + 5) {
                            Lev = j+2;
                        }
                    }
                }
            }
            System.out.println("Level:" + LevNum[Lev]);
        }

        if (Lev == LevNum.length - 1) {
            System.out.println("NONONONONO");
        } else if (Lev < 2) {     //level1 or 2
            for(int i = 0; i < 2; i++){
                if (LowLevel[Lev][i][0] - 5.0 <= x && x <= LowLevel[Lev][i][0] + 5.0) {
                    if (LowLevel[Lev][i][1] - 5 <= z && z <= LowLevel[Lev][i][1] + 5) {
                        return i;
                    }
                }
            }
        } else {      //level6,8,11
            for (int i = 0; i < 4; i++) {
                if (HighLevel[Lev-2][i][0] - 5 <= x && x <= HighLevel[Lev-2][i][0] + 5) {
                    if (HighLevel[Lev-2][i][1] - 5 <= z && z <= HighLevel[Lev-2][i][1] + 5) {
                        return i;
                    }
                }
            }
        }
        return 5;
    }
}
