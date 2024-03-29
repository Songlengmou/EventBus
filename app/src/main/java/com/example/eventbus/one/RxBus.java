package com.example.eventbus.one;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class RxBus {
    private final HashMap<Object, List<Subject>> maps = new HashMap<>();
    private static RxBus instance;

    private RxBus() {
    }

    public static RxBus get() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> Observable<T> register(@NonNull Object tag, @NonNull Class<T> clazz) {
        List<Subject> subjects = maps.get(tag);
        if (subjects == null) {
            subjects = new ArrayList<>();
            maps.put(tag, subjects);
        }
        Subject<T, T> subject = PublishSubject.create();
        subjects.add(subject);
        return subject;
    }

    @SuppressWarnings("unchecked")
    public void unregister(@NonNull Object tag, @NonNull Observable observable) {
        List<Subject> subjects = maps.get(tag);
        if (subjects != null) {
            subjects.remove(observable);
            if (subjects.isEmpty()) {
                maps.remove(tag);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void post(@NonNull Object o) {
        post(o.getClass().getSimpleName(), o);
    }

    @SuppressWarnings("unchecked")
    public void post(@NonNull Object tag, @NonNull Object o) {
        List<Subject> subjects = maps.get(tag);
        if (subjects != null && !subjects.isEmpty()) {
            for (Subject s : subjects) {
                s.onNext(o);
            }
        }
    }
}