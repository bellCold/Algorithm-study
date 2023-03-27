class Solution {
    static int[][] map;

    public int[] solution(String[] park, String[] routes) {

        // 4, 3
        map = new int[park.length][park[0].length()];

        int startX = 0;
        int startY = 0;

        // 0,1
        for (int i = 0; i < park.length; i++) {
            String[] split = park[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("S")) {
                    startX = i;
                    startY = j;
                    map[i][j] = 1;
                } else if (split[j].equals("O")) {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] split = routes[i].split(" ");
            String direction = split[0];
            int distance = Integer.parseInt(split[1]);

            boolean flag = true;
            switch (direction) {
                case "E":
                    if (startY + distance < park[0].length()) {
                        for (int j = startY; j <= startY + distance; j++) {
                            if (map[startX][j] == 0) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            startY += distance;
                        }
                    }
                    break;
                case "W":
                    if (startY - distance >= 0) {
                        for (int j = startY; j >= startY - distance; j--) {
                            if (map[startX][j] == 0) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            startY -= distance;
                        }
                    }
                    break;
                case "N":
                    if (startX - distance >= 0) {
                        for (int j = startX; j >= startX - distance; j--) {
                            if (map[j][startY] == 0) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            startX -= distance;
                        }
                    }
                    break;
                case "S":
                    if (startX + distance < park.length) {
                        for (int j = startX; j <= startX + distance; j++) {
                            if (map[j][startY] == 0) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            startX += distance;
                        }
                    }
                    break;
            }
        }

        return new int[]{startX, startY};
    }
    
}