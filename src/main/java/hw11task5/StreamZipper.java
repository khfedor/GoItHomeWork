package hw11task5;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamZipper {

    private static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        Iterator<T> zippingIterator = new Iterator<T>() {
            private boolean swicher = true;

            @Override
            public boolean hasNext() {
                if (swicher) {
                    return iterator1.hasNext();
                } else {
                    return iterator2.hasNext();
                }
            }

            @Override
            public T next() {
                T value;
                if (swicher) {
                    value = iterator1.next();
                } else {
                    value = iterator2.next();
                }
                swicher = !swicher;
                return value;
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(zippingIterator, 0),
                false
        );
    }

    public static void main(String[] args) {

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream1 = Stream.of(5, 6, 7, 8, 9);

        Stream<Integer> zippedStream = zip(stream1, stream2).sorted();

        zippedStream.forEach(System.out::println);
    }
}
