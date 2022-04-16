package com.company;

public class MyHashSet implements MySet{

        public static class EntrySet{
            String string;
            int hashCode;

            public EntrySet(String string, int hashCode){
                this.string = string;
                this.hashCode = hashCode;
            }
        }

        private int size = 0;
        private int capacity = 16;
        private EntrySet[] arr = new EntrySet[capacity];

        @Override
        public boolean add(String e) {
            if (e == null || contains(e)) return false;
            if (size >= arr.length){
                int newCapacity = capacity + 6;
                EntrySet[] newArr = new EntrySet[newCapacity];
                System.arraycopy(arr, 0, newArr, 0, size+1);
                capacity = newCapacity;
                arr = newArr;
            }
            arr[size] = new EntrySet(e, e.hashCode());
            size++;
            return true;
        }

        @Override
        public void clear() {
            for (int i=size; i>0; i--){
                remove(arr[i-1].string);
            }
        }

        @Override
        public boolean contains(String o) {
            if (o != null && size > 0){
                for (EntrySet object: arr){
                    if(check(object, o)){
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public boolean isEmpty() {
            if (size != 0) {
                for (EntrySet o : arr) {
                    if (o != null && o.string != null) return false;
                }
                return true;
            }
            return true;
        }

        @Override
        public boolean remove(String o) {
            if(contains(o)){
                for (EntrySet object : arr){
                    if(check(object, o)){
                        object.string = null;
                        object.hashCode = 0;
                    }
                }
                return true;
            }
            return false;
        }

        @Override
        public int size(MyHashSet o) {
            return toArray().length;
        }

        @Override
        public String[] toArray() {
            String[] result = new String[size];
            for (int i = 0; i < size; i++) {
                    result[i] = arr[i].string;
            }
            return result;
        }

        private boolean check(EntrySet object, String o){
            return object != null && object.string != null && object.string.equals(o);
        }
}
