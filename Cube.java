public class Cube{
    //Warning. In this file is some truly awful code.

    static String[][] cube = {
    {"w","w","w",       //          w,w,w
     "w","w","w",       //          w,w,w
     "w","w","w"},      //          w,w,w
                        
                        //   o,o,o  b,b,b  r, r, r
    {"o","o","o",       //   o,o,o  b,b,b  r, r, r
     "o","o","o",       //   o,o,o  b,b,b  r, r, r
     "o","o","o",},     
                        //          g,g,g
                        //          g,g,g          
    {"b","b","b",       //          g,g,g
     "b","b","b",       
     "b","b","b"},      //          y,y,y
                        //          y,y,y
                        //          y,y,y
     
    {"r","r","r",       
     "r","r","r",       
     "r","r","r"},      
               
     
    {"g","g","g",       
     "g","g","g",       
     "g","g","g"},      

     
    {"y","y","y",
     "y","y","y",
     "y","y","y"}};


    static void printCube(){
        System.out.println();
        
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0){
                System.out.print("      " + cube[0][i] + "|");
            } else if (i %3 < 2){
                System.out.print(cube[0][i] + "|");
            } else{
                System.out.println(cube[0][i]);
                }}
        //My mind has left me
        System.out.println(cube[1][0] + "|" + cube[1][1] + "|" + cube[1][2] + "|" + cube[2][0] + "|" +cube[2][1] + "|" +cube[2][2] + "|" + cube[3][0] + "|" +cube[3][1] + "|" +cube[3][2]);
        System.out.println(cube[1][3] + "|" + cube[1][4] + "|" + cube[1][5] + "|" + cube[2][3] + "|" +cube[2][4] + "|" +cube[2][5] + "|" + cube[3][3] + "|" +cube[3][4] + "|" +cube[3][5]);
        System.out.println(cube[1][6] + "|" + cube[1][7] + "|" + cube[1][8] + "|" + cube[2][6] + "|" +cube[2][7] + "|" +cube[2][8] + "|" + cube[3][6] + "|" +cube[3][7] + "|" +cube[3][8]);
       //I tried to write a loop to do all of that with the updated cube structure but for some reason I couldn't quite get it. I worked on that for an hour before having to accept that writing this out would be faster.
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0){
                System.out.print("      " + cube[4][i] + "|");
            } else if (i %3 < 2){
                System.out.print(cube[4][i] + "|");
            } else{
                System.out.println(cube[4][i]);
                }}
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0){
                System.out.print("      " + cube[5][i] + "|");
            } else if (i %3 < 2){
                System.out.print(cube[5][i] + "|");
            } else{
                System.out.println(cube[5][i]);
                }}

        
        
        }


    static String[][] cloneCube(){
        String[][] cubeClone = new String[12][0];
        for(int i = 0; i < 6; i++){
            cubeClone[i] = cube[i].clone();
        }
        return cubeClone;
    }

    static void rotateFace(Integer faceInd, Boolean left){
        //This is used by the other methods below to rotate a face left or right.
        
        //Clone a face of the cube.
        String[] temp = cloneCube()[faceInd];
        String[] face = cube[faceInd];
        
        if(left){
            face[0] = temp[2];
            face[2] = temp[8];
            face[8] = temp[6];
            face[6] = temp[0];

            face[1] = temp[5];
            face[5] = temp[7];
            face[7] = temp[3];
            face[3] = temp[1];
        }

        else{
            face[0] = temp[6];
            face[2] = temp[0];
            face[8] = temp[2];
            face[6] = temp[8];

            face[1] = temp[3];
            face[5] = temp[1];
            face[7] = temp[5];
            face[3] = temp[7];
        }
    }

    static void sideRotate(String move){
        String[][] temp = cloneCube(); //Create a non-reference cube copy.
        switch (move) { //All hail the great switch case.
            case "u":
                for(int i = 0; i < 3 ; i++){
                    cube[1][i] = temp[2][i];
                    cube[2][i] = temp[3][i];
                    cube[3][i] = temp[5][8-i];
                    cube[5][8-i] = temp[1][i];}
                rotateFace(0,false);
                break;
            case "u'":
                for(int i = 0; i < 3 ; i++){
                    cube[1][i] = temp[5][8-i];
                    cube[2][i] = temp[1][i];
                    cube[3][i] = temp[2][i];
                    cube[5][8-i] = temp[3][i];}
                rotateFace(0,true);
                break;
            case "d":
                for(int i = 6; i < 9 ; i++){
                    cube[1][i] = temp[2][i];
                    cube[2][i] = temp[3][i];
                    cube[3][i] = temp[5][8-i];
                    cube[5][8-i] = temp[1][i];}
                rotateFace(4, false);
                break;
            case "d'":
                for(int i = 6; i < 9 ; i++){
                    cube[1][i] = temp[5][8-i];
                    cube[2][i] = temp[1][i];
                    cube[3][i] = temp[2][i];
                    cube[5][8-i] = temp[3][i];}
                rotateFace(4, true);
                break;
            case "r":
                for(int i = 2; i < 9 ; i+=3){
                    cube[0][i] = temp[2][i];
                    cube[2][i] = temp[4][i];
                    cube[4][i] = temp[5][i];
                    cube[5][i] = temp[0][i];}
                rotateFace(3,false);
                break;
            case "r'":
                for(int i = 2; i < 9 ; i+=3){
                    cube[0][i] = temp[5][i];
                    cube[2][i] = temp[0][i];
                    cube[4][i] = temp[2][i];
                    cube[5][i] = temp[4][i];}
                rotateFace(3,true);
                break;
            case "l":
                for(int i = 0; i < 7 ; i+=3){
                    cube[0][i] = temp[2][i];
                    cube[2][i] = temp[4][i];
                    cube[4][i] = temp[5][i];
                    cube[5][i] = temp[0][i];}
                rotateFace(3,false);
                break;
            case "l'":
                for(int i = 0; i < 7 ; i+=3){
                    cube[0][i] = temp[5][i];
                    cube[2][i] = temp[0][i];
                    cube[4][i] = temp[2][i];
                    cube[5][i] = temp[4][i];}
                rotateFace(3,true);
                break;
            case "f":
                for(int i = 0; i < 3 ; i++){
                    cube[0][6+i] = temp[1][i+2*(1+i)]; //so face0 678 are replaced by face1 258
                    cube[1][i+2*(1+i)] = temp[4][i];
                    cube[4][i] = temp[3][i+2*(1+i)-2]; //so face4 012 are replaced by face3 036
                    cube[3][i+2*(1+i)-2] = temp[0][5+i];}
                rotateFace(2,false);
                break;
            case "f'":
                for(int i = 0; i < 3 ; i++){
                    cube[0][6+i] = temp[3][i+2*(1+i)-2]; 
                    cube[1][i+2*(1+i)] = temp[0][5+i];
                    cube[4][i] = temp[1][i+2*(1+i)]; 
                    cube[3][i+2*(1+i)-2] = temp[4][i];}
                rotateFace(2,true);
                break;
            case "b":
                for(int i = 0; i < 3 ; i++){
                    cube[0][i] = temp[1][i+2*(1+i)-2]; //so face0 678 are replaced by face1 258
                    cube[1][i+2*(1+i)-2] = temp[4][i];
                    cube[4][6+i] = temp[3][i+2*(1+i)]; //so face4 012 are replaced by face3 036
                    cube[3][i+2*(1+i)] = temp[0][5+i];}
                rotateFace(5, false);
                break;
            case "b'":
                for(int i = 0; i < 3 ; i++){
                    cube[0][i] = temp[3][i+2*(1+i)];
                    cube[1][i+2*(1+i)-2] = temp[0][5+i];
                    cube[4][6+i] = temp[1][i+2*(1+i)-2];
                    cube[3][i+2*(1+i)] = temp[4][i];}
                rotateFace(5, true);
                break;
            default:
                System.out.println("Something has gone wrong. A move entered was not a valid input.");
                System.out.println("The character entered was: " + move);
                break;
        }
    }

    public static void main(String[] args){
        //First, print the cube
        printCube();
        sideRotate("b");
        printCube();
    }
}