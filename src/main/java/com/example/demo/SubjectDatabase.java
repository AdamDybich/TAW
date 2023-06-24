package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class SubjectDatabase {
    private List<Subject> subjectList = new ArrayList<>();

    private int subjectIndex = 1;

    /**
     * Dodaje nowy przedmiot do bazy danych.
     *
     * @param subject Nowy przedmiot
     */
    public void addSubject(Subject subject) {
        subject.setId(subjectIndex);
        subjectList.add(subject);
        subjectIndex++;
    }

    /**
     * Zwraca listę przedmiotów z bazy danych, opcjonalnie filtrowaną według wartości egzaminu i sali.
     *
     * @param egzamin Informacja, czy przedmiot kończy się egzaminem
     * @param sala    Numer sali, w której odbywają się zajęcia
     * @return Lista przedmiotów z bazy danych
     */
    public List<Subject> getSubjectList(Boolean egzamin, String sala) {
        if (egzamin == null && sala == null) {
            return subjectList;
        }
        List<Subject> filteredSubjects = new ArrayList<>();
        for (Subject subject : subjectList) {
            if (sala == null && subject.getEgzamin() == egzamin) {
                filteredSubjects.add(subject);
            } else if (egzamin == null && !subject.getSala().equals(sala)) {
                filteredSubjects.add(subject);
            } else if (subject.getSala().equals(sala) && subject.getEgzamin() == egzamin) {
                filteredSubjects.add(subject);
            }
        }
        return filteredSubjects;
    }

    /**
     * Usuwa wszystkie przedmioty z bazy danych.
     */
    public void deleteAll() {
        subjectList.clear();
    }

    /**
     * Znajduje przedmiot z bazy danych na podstawie jego identyfikatora.
     *
     * @param id Identyfikator przedmiotu
     * @return Znaleziony przedmiot lub null, jeśli nie istnieje
     */
    public Subject getSubjectById(Integer id) {
        for (Subject subject : subjectList) {
            if (subject.getId().equals(id)) {
                return subject;
            }
        }
        return null;
    }

    /**
     * Usuwa przedmiot z bazy danych na podstawie jego identyfikatora.
     *
     * @param id Identyfikator przedmiotu
     * @return true, jeśli przedmiot został usunięty, false w przeciwnym razie
     */
    public boolean deleteById(Integer id) {
        Subject subjectToDelete = null;
        for (Subject subject : subjectList) {
            if (subject.getId().equals(id)) {
                subjectToDelete = subject;
            }
        }
        if (subjectToDelete == null) {
            return false;
        }
        subjectList.remove(subjectToDelete);
        return true;
    }
}
