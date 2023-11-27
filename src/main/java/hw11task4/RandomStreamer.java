package hw11task4;

import java.util.stream.Stream;

import static java.lang.System.currentTimeMillis;

public class RandomStreamer {

    private final long a = 25214903917L;
    private final int c = 11;
    private final int m = 2 ^ 48;


    private long seed = currentTimeMillis();


    public Stream<Long> Randomizer(long a, int c, int m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        RandomStreamer randomStreamer = new RandomStreamer();

        randomStreamer.Randomizer(randomStreamer.a, randomStreamer.c, randomStreamer.m).forEach(System.out::println);
    }
}


