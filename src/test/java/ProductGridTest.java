
import one.ProductGrid ;
import junit.framework.TestCase;
import org.junit.Test ;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;


import static org.fest.assertions.api.Assertions.assertThat;

public class ProductGridTest extends TestCase {


    @Test
    public void test_all_zero_should_return_zero()
    {
        int[][] input = {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}} ;
        int output = 0 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);

    }

    @Test
    public void test_horizontal_line() {
        int[][] input =
                {{0,0,0,0,0,0},
                {0,1,2,3,4,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}} ;
        int output = 24 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }

    @Test
    public void test_vertical_line() {
        int[][] input =
                       {{0,0,0,0,0,0},
                        {0,1,0,0,0,0},
                        {0,2,0,0,0,0},
                        {0,3,0,0,0,0},
                        {0,4,0,0,0,0},
                        {0,0,0,0,0,0}} ;
        int output = 24 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }

    @Test
    public void test_diagonal_line_right() {
        int[][] input = {{0,0,0,0,0,0},
                        {0,1, 0,0,0,0},
                        {0,0,2,0,0,0},
                        {0,0,0,5,0,0},
                        {0,0,0,0,1,0},
                        {0,0,0,0,0,0}} ;
        int output = 10 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }
    @Test
       public void test_diagonal_line_left() {
        int[][] input = {{0,0,0,0,0,0},
                {0,0, 0,0,0,0},
                {0,0,0,0,10,0},
                {0,0,0,5,0,0},
                {0,0,3,0,0,0},
                {0,10,0,0,0,0}} ;
        int output = 1500 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }
    @Test
    public void test_non_square_matrix() {
        int[][] input = {
                {0,0,0,10,0,0},
                {0,0,10,0,0,0},
                {0,10,0,0,0,0},
                {10,0,0,0,0,0}} ;
        int output = 10000 ;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }
    @Test
    public void test_acceptance() {
        int[][] input = scanData() ;
        int output = 70600674;
        assertThat(ProductGrid.compute(input)).isEqualTo(output);
    }

    int[][] scanData()
    {
    int height = 0;
    int width = 0 ;

        File file = new File("src/input.txt");

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                   width = line.split("\\s+").length;
                   height++ ;
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    int[][] grid = new int[height][width] ;
        try {
            Scanner scanner = new Scanner(file);
            for(int j = 0 ; j < height ; j++) {
                for(int i = 0 ; i < width ; i++) {
                    grid[j][i] = Integer.parseInt(scanner.next());
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

 return grid ;

    }
    @Test
    public void test_all() {
        test_all_zero_should_return_zero() ;
        test_horizontal_line() ;
        test_vertical_line();
        test_diagonal_line_right() ;
        test_diagonal_line_left() ;
        test_non_square_matrix();
        test_acceptance();
    }

}
