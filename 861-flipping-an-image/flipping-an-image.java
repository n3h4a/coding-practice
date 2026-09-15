class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for(int i = 0; i < image.length; i++){

            for(int j = 0; j < (image[i].length + 1 ) /2; j++){

                int opposite =  image[i].length - 1 - j;
                int temp = image[i][j];
                image[i][j] = 1 - image[i][opposite];
                image[i][opposite] = 1 - temp;

            }

        }

        return image;
    }
}