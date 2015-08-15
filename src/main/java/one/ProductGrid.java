package one;


public class ProductGrid {

    public static int compute(int[][] grid)
    {
        int maxProduct = 0 ;


        for(int yCoordinate = 0 ; yCoordinate < height(grid) ;yCoordinate++)
        {
            for(int xCoordinate = 0 ; xCoordinate<width(grid) ; xCoordinate++ )
            {
                maxProduct = Math.max(horizontalCheck(grid, yCoordinate, xCoordinate),maxProduct);
                maxProduct = Math.max(verticalCheck(grid, yCoordinate, xCoordinate),maxProduct);
                maxProduct = Math.max(diagonalCheckRight(grid, yCoordinate, xCoordinate),maxProduct);
                maxProduct = Math.max(diagonalCheckLeft(grid, yCoordinate, xCoordinate), maxProduct);
            }
        }
        return maxProduct ;
    }

    private static int verticalCheck(int[][] grid, int yCoordinate, int xCoordinate) {
        int product =1 ;

        int height = height(grid) ;
        for(int index = 0 ; index <4 ;index++)
        {
            if(yCoordinate +index < height)
            {
                product = product * grid[yCoordinate +index][xCoordinate];
            }
        }
        return product;
    }

    private static int horizontalCheck(int[][] grid,  int yCoordinate, int xCoordinate) {
        int product = 1 ;
        int width = width(grid);

        for(int index = 0 ; index <4 ;index++)
        {
            if(xCoordinate +index < width)
            {
                product = product * grid[yCoordinate][xCoordinate + index];
            }
        }
        return product;
    }



    private static int diagonalCheckRight(int[][] grid, int yCoordinate, int xCoordinate) {
        int product = 1 ;
        int width = width(grid);
        int height = grid.length ;
        for(int index = 0 ; index <4 ;index++)
        {
            if(xCoordinate +index < width && yCoordinate +index < height)
            {
                product = product * grid[yCoordinate +index][xCoordinate + index];
            }
        }
        return product;
    }

    private static int diagonalCheckLeft(int[][] grid, int yCoordinate, int xCoordinate) {
        int product = 1 ;
        int width = width(grid);
        int height = height(grid);
        for(int index = 0 ; index <4 ;index++)
        {
            if(xCoordinate -index >= 0 && yCoordinate +index < height)
            {
                product = product * grid[yCoordinate +index][xCoordinate - index];
            }
        }
        return product;
    }

    private static int height(int[][] grid) {
        return grid.length;
    }

    private static int width(int[][] grid) {
        return grid[0].length;
    }
}
