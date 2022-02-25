package programmers.level3;

import java.io.*;
import java.util.*;

/**
 * PROGRAMMERS 42579 베스트앨범
 * Level 3
 * 해시
 */

public class PROGRAMMERS_42579_1 {

    static final int MAX_COUNT = 2;

    static int SIZE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = {};

        SIZE = genres.length;
        Map<String, Integer> totalPlaysMap = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            totalPlaysMap.put(genres[i], totalPlaysMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Song[] songs = new Song[SIZE];
        for (int i = 0; i < SIZE; i++) {
            songs[i] = new Song(i, plays[i], totalPlaysMap.get(genres[i]), genres[i]);
        }
        Arrays.sort(songs);

        List<Integer> albums = new ArrayList<>();
        Map<String, Integer> albumCount = new HashMap<>();
        for (int i = 0; i < SIZE; i++) {
            Song song = songs[i];
            if (albumCount.getOrDefault(song.getGenres(), 0) < MAX_COUNT) {
                albums.add(song.getSeq());
                albumCount.put(song.getGenres(), albumCount.getOrDefault(song.getGenres(), 0) + 1);
            }
        }

        answer = albums.stream().mapToInt(i -> i).toArray();

        // output
        bw.write(Arrays.toString(answer));

        // io close
        bw.close();
        br.close();
    }

    static class Song implements Comparable<Song> {

        private final int seq;

        private final int plays;

        private final int genresPlays;

        private final String genres;

        public Song(int seq, int plays, int genresPlays, String genres) {
            this.seq = seq;
            this.plays = plays;
            this.genresPlays = genresPlays;
            this.genres = genres;
        }

        @Override
        public int compareTo(Song o) {
            if (this.genres.equals(o.getGenres())) {
                if (this.plays == o.getPlays()) {
                    return Integer.compare(this.seq, o.getSeq());
                } else {
                    return Integer.compare(this.plays, o.getPlays()) * -1;
                }
            } else {
                return Integer.compare(this.genresPlays, o.getGenresPlays()) * -1;
            }
        }

        public int getSeq() {
            return seq;
        }

        public int getPlays() {
            return plays;
        }

        public int getGenresPlays() {
            return genresPlays;
        }

        public String getGenres() {
            return genres;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "seq=" + seq +
                    ", plays=" + plays +
                    ", genresPlays=" + genresPlays +
                    ", genres='" + genres + '\'' +
                    '}';
        }
    }
}
