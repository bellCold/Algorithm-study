class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int curX = 0;
        int curY = 0;

        int boardXSize = board[0] / 2;
        int boardYSize = board[1] / 2;
        for (String direction : keyinput) {
            switch (direction) {
                case "left":
                    if (curX != boardXSize * -1) {
                        curX--;
                    }
                    break;
                case "right":
                    if (curX != boardXSize) {
                        curX++;
                    }
                    break;
                case "up":
                    if (curY != boardYSize) {
                        curY++;
                    }
                    break;
                case "down":
                    if (curY != boardYSize * -1) {
                        curY--;
                    }
                    break;
            }
        }

        return new int[]{curX, curY};
    }
}