import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<Integer, String> gMap = new HashMap<>(); // 노래고유번호, 장르
        Map<Integer, Integer> pMap = new HashMap<>(); // 노래고유번호, 플레이횟수

        for (int i = 0; i < genres.length; i++)
            gMap.put(i, genres[i]);

        for (int i = 0; i < genres.length; i++)
            pMap.put(i, plays[i]);

        Set<String> gSet = new HashSet<>();

        for (int i = 0; i < genres.length; i++)
            gSet.add(genres[i]); // 중복 x 총 장르

        // 1단계: 장르별 플레이 총 횟수 담기

        Map<Integer, String> copMap = new HashMap<>(); // 총 플레이 횟수, 장르
        for (String genre : gSet) {
            int count = 0;
            for (int i = 0; i < gMap.size(); i++) {
                if (gMap.get(i).equals(genre))
                    count += pMap.get(i);
            }
            copMap.put(count, genre);
        }

        // 2단계: 장르별 총 플레이 횟수를 기준으로 정렬

        Map<Integer, String> sortMap = new TreeMap<>(Comparator.reverseOrder()); // TreeMap에 넣어주면 자동으로 Key값에 의해
                                                                                 // 정렬(역정렬=내림차순)
        sortMap.putAll(copMap);

        // 3단계: 장르 안에 노래들 2곡 씩 뽑기

        List<Integer> list = new ArrayList<>();
        for (String genre : sortMap.values()) {

            Queue<Song> q = new PriorityQueue<>();
            for (Integer idx : gMap.keySet()) {
                if (gMap.get(idx).equals(genre)) {
                    q.offer(new Song(idx, pMap.get(idx)));
                }
            }

            int count = 0;
            while (!q.isEmpty()) {
                if (count == 2)
                    break;
                list.add(q.poll().idx);
                count++;
            }

        }

        // 최종 답 도출
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    static class Song implements Comparable<Song> {
        int idx;
        int play;

        Song(int idx, int play) {
            this.play = play;
            this.idx = idx;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play > o.play) {
                return -1;
            } else {
                return 1;
            }
        }

    }
}