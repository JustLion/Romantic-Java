package com.liang.erhua.datastructure.sparsearray;

import java.io.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 11:39/2020-04-11
 * @description 算法实现基础：实现五子棋程序存盘退出和续上盘功能
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建原始的二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.printf("%d\t",chessArr1[i][j]);
            }
            System.out.println();
        }
        // 遍历二维数组得出数组中有效数据的数量
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("原始数组共有" + sum +"个有效数据！");
        // 创建稀疏数组并为稀疏数组赋值
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int num = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = chessArr1[i][j];
                    num++;
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t",sparseArr[i][j]);
            }
            System.out.println();
        }
        // 将稀疏数组写入到文件map.data中
        File file = new File("g:\\map.data");
        try(FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[i].length; j++) {
                    writer.write(sparseArr[i][j] + "\t");
                }
                writer.write("\r\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 从map.data中读取稀疏数组

        String line;
        int row = 0;
        int rowNum = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                rowNum = line.split("\t").length;
                row++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        int[][] sparseArr2 = new int[row][rowNum];
        int rowNumber = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] rowLine = line.split("\t");
                for (int i = 0; i < rowLine.length; i++) {
                    sparseArr2[rowNumber][i] = Integer.parseInt(rowLine[i]);
                }
                rowNumber++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 将稀疏数组还原为二维数组
        int[][]chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }
        //打印还原后的二维数组
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.printf("%d\t",chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
