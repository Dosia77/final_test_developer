package com.animals.models.repositoryHF;

import java.time.LocalDate;
import java.util.List;

import com.animals.models.animals1.HumanFriends;

public interface HFrepository {

    void printHF(List<HumanFriends> list);
    HumanFriends createFriends(int number,String type, String name, LocalDate birthDate);
    void deleteHFriend(int number, List<HumanFriends> list);
    void printCommands(int number,List<HumanFriends> list);
    void addCommands(int number,List<HumanFriends> list);
    void getCount(List<HumanFriends> list);
}