import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import za.ac.wits.snake.DevelopmentAgent;

public class MyAgent extends DevelopmentAgent {

    public static void main(String args[]) {
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            //initialization string which consists of 4 50 50 1 - Number of snakes, width + height + mode
            String initString = br.readLine();
            String[] temp = initString.split(" ");
            //Number of snakes
            int nSnakes = Integer.parseInt(temp[0]);

            while (true) {
                String line = br.readLine();
                if (line.contains("Game Over")) {
                    break;
                }

                String apple1 = line; //co-ordinates of the first apple
                String apple2 = br.readLine(); //co-ordinates of the second apple
                String[] coords = apple2.split(" ");
                String[] coord = apple1.split(" ");
                int apple1x = Integer.parseInt(coord[0]);
                int apple1y = Integer.parseInt(coord[1]);
                int apple2x = Integer.parseInt(coords[0]);
                int apple2y = Integer.parseInt(coords[1]);

                //do stuff with apples

                int mySnakeNum = Integer.parseInt(br.readLine()); //reads in the snake number
                int headX = 0;
                int headY = 0;
                int tailX = 0;
                int tailY = 0;

                for (int i = 0; i < nSnakes; i++) {

                    //snake details: state, length, kills, headX, headY, body...., TailX,TailY
                    String snakeLine = br.readLine();

                    if (i == mySnakeNum) {

                        String[] temporary = snakeLine.split(" ");
                        if(temporary[0].equals("invisible")){
                            String snakeHeadTemp = temporary[5];
                            String[] snakeHead = snakeHeadTemp.split(",");
                            headX = Integer.parseInt(snakeHead[0]);
                            headY = Integer.parseInt(snakeHead[1]);
                        }
                        else{
                            String snakeHeadTemp = temporary[3];
                            String[] snakeHead = snakeHeadTemp.split(",");
                            headX = Integer.parseInt(snakeHead[0]);
                            headY = Integer.parseInt(snakeHead[1]);

                        }

                    }

                    //do stuff with other snakes
                }

                //finished reading, calculate move:
                int move = -1;

                if (apple1x == -1 && apple1y == -1){
                    if (apple2y < headY){
                        move = 0;
                    }
                    else if (apple2y > headY){
                        move = 1;
                    }
                    else if (apple2x < headX){
                        move = 2;
                    }
                    else if (apple2x > headX){
                        move = 3;
                    }
                }
                else{
                    if (apple1y < headY){
                        move = 0;
                    }
                    else if (apple1y > headY){
                        move = 1;
                    }
                    else if (apple1x < headX){
                        move = 2;
                    }
                    else if (apple1x > headX){
                        move = 3;
                    }
                }



                System.out.println(move);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}