package free.course.baseball.common;

import free.course.baseball.domain.Result;

import java.io.*;
import java.util.EnumMap;

public class Printer {

    public static final String INPUT_NUM_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String REPLAY_GUIDE_MESSAGE = "게임 새로 하기 [1.계속 / 2.종료] : ";
    public static final String NOT_VALID_INPUT_MESSAGE = "입력이 잘못되었습니다. 다시 입력해주세요.\n";

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    String getInputString() throws IOException {
        bw.write(INPUT_NUM_GUIDE_MESSAGE);
        bw.flush();
        return br.readLine();
    }

    String getReplayMessage() throws IOException {
        bw.write(REPLAY_GUIDE_MESSAGE);
        bw.flush();
        return br.readLine();
    }

    public void close() throws IOException {
        br.close();
        bw.close();
    }

    public void notValidMessage() throws IOException {
        bw.write(NOT_VALID_INPUT_MESSAGE);
        bw.flush();
    }

    public int printResult(EnumMap<Result, Integer> matching) throws IOException{
        bw.write(createResultString(matching));
        bw.flush();
        return matching.getOrDefault(Result.STRIKE, 0);
    }

    private String createResultString(EnumMap<Result, Integer> matching) {
        return matching.getOrDefault(Result.STRIKE, 0) +
                " 스트라이크 / " +
                matching.getOrDefault(Result.BALL, 0) +
                " 볼 / " +
                matching.getOrDefault(Result.NOTHING, 0) +
                " 낫싱\n";

    }
}
