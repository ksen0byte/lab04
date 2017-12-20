package com.ksenobyte;

public class MyDeque<E> {
    private Object[] elements;
    private Integer head;
    private Integer tail;

    public MyDeque() {
        elements = new Object[16];
        head = tail = 8;
    }

    private void ensureCapacity() {
        int size = size();
        int length = elements.length;
        if (tail == length - 1 || head == 1) {
            Object[] newElements = new Object[length * 2];
            System.arraycopy(elements, head, newElements, length - size / 2, size);
            head = length - size / 2;
            tail = length + size / 2;
            this.elements = newElements;
        }
    }


    public int size() {
        return tail - head;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Object o) {
        for (Object element : elements) {
            if (element.equals(o)) return true;
        }
        return false;
    }

    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        head--;
        ensureCapacity();
        elements[head + 1] = e;
    }

    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        tail++;
        ensureCapacity();
        elements[tail] = e;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void clear() {
        elements = new Object[16];
    }


    public E pollFirst() {
        E element = (E) elements[head];
        elements[++head] = null;
        return element;
    }


    public E pollLast() {
        E element = (E) elements[tail];
        elements[tail] = 0;
        head--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public E peekFirst() {
        return (E) elements[head + 1];
    }


    @SuppressWarnings("unchecked")
    public E peekLast() {
        return (E) elements[tail];
    }

    public E poll() {
        return pollFirst();
    }

    public E peek() {
        return peekFirst();
    }


    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return pollFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (Object element : elements) {
            if (element != null) {
                result.append(element).append(", ");
            }
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
