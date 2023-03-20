package GenericList;

import java.util.Arrays;

public class MyList<T>  {

    private T[] array;
    private int capacity=10;

    public MyList(int capacity){
        if(this.capacity<capacity){
            this.capacity*=2;
        }
        array = (T[])(new Object[this.capacity]);

    }
    public MyList(){
        array =(T[])(new Object[this.capacity]);
    }

    public int size(){
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                count++;
            }
        }
        return count;
    }
    public void moreCapacity(){
        if(size()==getCapacity()){
            capacity*=2;
            T[] oldArray =array;
            array=(T[])(new Object[capacity]);
           for(int i=0;i<oldArray.length;i++){
               array[i]=oldArray[i];
           }
        }


    }
    public T get(int index){
        if(index>= array.length){
            return null;
        }
        return array[index];
    }

    public void add(T data){
        for(int i = 0; i< array.length; i++){

            if(array[i]==null){
                array[i]=data;
                break;
            }
        }
        moreCapacity();
    }
    public void remove(int index){
        if(index>=array.length||index<0){
            System.out.println("Geçersiz sayı girdiniz.");
        }
        array[index]=null;
        for(int i = 0; i< array.length; i++){
            T tempValue=null;
            if((i+1)<array.length){
                 tempValue= array[i+1];
                if(array[i]==null&& array[i+1]!=null){
                    array[i+1]= array[i];
                }else if(array[i]==null&& array[i+1]==null){
                    array[i]=tempValue;
                }
            }

        }
    }
    public void set(int index,T data){
        if(index>=array.length||index<0){
            System.out.println("Geçersiz index girdiniz.");
        }else{
            array[index]=data;
        }
    }
    public int getCapacity(){
        return capacity;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        String turnback="";
        for(int i=0;i<array.length;i++){
            if(array[i]!=null){
                if(i==0)
                    turnback="[";
                turnback+=array[i]+",";
                }
            if(isEmpty()){
                turnback="[]";
                return turnback;
            }
        }
        turnback=turnback.substring(0,turnback.length()-1);
        turnback+="]";
        return turnback;
    }

    public int indexOf(T data){
        for(int i=0;i<array.length;i++){
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for(int i=array.length-1;i>=0;i--){
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        int result=0;
        for(int i=array.length-1;i>=0;i--){
            if(array[i]==null){
              result=-1;
            }else {
                result=+1;
            }
        }
        if(result==-1){
            return true;
        }else if(result==1){
            return false;
        }
        return false;
    }

    public T[] toArray(){

        Object[] oldArray =array;
         return Arrays.copyOf(array, array.length);
    }
    public void clear(){
        for(int i=array.length-1;i>=0;i--){
            array[i]=null;
        }
    }
    public MyList<T> subList(int start,int finish){
        MyList<T> newList=new MyList<>(finish);
        T[] newArray= Arrays.copyOfRange(array,start,finish+1);
        newList.setArray(newArray);
        return newList;
    }
    public boolean contains(T data){
        for(int i =0;i< array.length;i++){
            if(array[i]==data){
                return true;
            }
        }
        return false;
    }
}
