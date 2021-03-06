package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount = 0;

    @Override
    public void add(E value) {
        Node<E> previous = last;
        Node<E> newElement = new Node<>(value, null, previous);
        last = newElement;
        if (previous == null) {
            first = newElement;
        } else {
            previous.next = newElement;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;

        }
        return node.item;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<E> cursor = first;

            @Override
            public boolean hasNext() {
                return cursor != null;
                }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Please wait few second an try again.");
                } else if (!hasNext()) {
                    throw new NoSuchElementException("Please wait few second an try again.");
                }
                E returnItem = cursor.item;
                cursor = cursor.next;
                return returnItem;
            }
        };
    }
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}