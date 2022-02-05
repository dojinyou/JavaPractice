package com.dojinyou.javajungsuk.formatting;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatEx {
    public static void main(String[] args) throws ParseException {
        final String[][] SAMPLE_DATA = {
            {"홍길동","23","남자","010-1234-4567"},
            {"심청이","23","여자","010-9876-5432"},
            {"김에러","99","남녀","101231321"}
        };
        
        String pattern = "이름 : {0}, 성별 : {2}, 나이 : {1}, 연락처 : {3}";
        MessageFormat mf = new MessageFormat(pattern);
        for(String[] data : SAMPLE_DATA) {
            String result = mf.format(data);
            System.out.println(result);
            /* 출력결과
            * 이름 : 홍길동, 성별 : 남자, 나이 : 23, 연락처 : 010-1234-4567
            * 이름 : 심청이, 성별 : 여자, 나이 : 23, 연락처 : 010-9876-5432
            * 이름 : 김에러, 성별 : 남녀, 나이 : 99, 연락처 : 101231321
            * */
            try {
                Object[] parseDataArray = mf.parse(result);
                for (Object parseData : parseDataArray) {
                    System.out.print(parseData+", ");
                }
                System.out.println();
            } catch (ParseException e) {
                System.out.println("e = " + e);
            }
            
        }
    }
}
