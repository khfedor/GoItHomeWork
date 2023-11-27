package hw9tasks.hw9task1;

    // implementation of methods for an ArrayList-like collection;
    public class MyArrayList {
        private Object[] array;
        private int size;

        public MyArrayList() {
            this.array = new Object[2];
            this.size = 0;
        }

        public MyArrayList(int size) {
            this.array = new Object[size];
            this.size = 0;
        }


        public Object get(int index) {
            if (index > array.length || index < 0) {
                throw new ArrayIndexOutOfBoundsException("You trying to get an index " + index + ".\nThis index don't have, " +
                        "please enter index range from 0 to " + array.length + ".\n");
            }
            return array[index];
        }


        // this method adds a new element to the end of the collection;
        public void add(Object value) {
            if (size == array.length) {
                Object[] arrays1 = new Object[array.length + 1];
                System.arraycopy(array, 0, arrays1, 0, size);
                array = arrays1;
            }
            array[size] = value;
            size++;
        }


        // this method removes all elements and sets the size to zero;
        public void remove(int index) {
            if (index > array.length || index < 0) {
                throw new ArrayIndexOutOfBoundsException("You delete an index " + index + ".\nThis index don't have, please " +
                        "enter index range from 0 to " + array.length + ".\n");
            } else {
                System.arraycopy(array, 0, array, index, size - index - 1);
                array[index] = null;
            }
        }


        // this method assigns a "null" value to all elements;
        public void clear() {
            for (int i = 0; i < array.length; i++) {
                array[i] = null;
                size = 0;
            }
        }

        // this method prints all the values of the elements to the console;
        public void printArrays() {
            for (int i = 0; i < array.length; i++) {
                System.out.print(get(i) + " ");
            }
            System.out.println();
        }

        //  this method returns the number that equals the sum of all elements in the collection;
        public int size() {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    size--;
                }
            }
            return size;
        }
    }

