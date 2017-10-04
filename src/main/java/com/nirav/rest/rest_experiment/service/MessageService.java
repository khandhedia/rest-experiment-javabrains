package com.nirav.rest.rest_experiment.service;

import com.nirav.rest.rest_experiment.database.DatabaseClass;
import com.nirav.rest.rest_experiment.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.nirav.rest.rest_experiment.database.DatabaseClass.*;

public class MessageService
{
    private static Map<Integer, Message> messages = getMessages();

    {
        Message m1 = new Message(1, "Hi Nirav", "Nirav");
        Message m2 = new Message(2, "Hi Mittal", "Mittal");
        Message m3 = new Message(3, "Hi Mitul", "Mitul");
        messages.put(m1.getId(), m1);
        messages.put(m2.getId(), m2);
        messages.put(m3.getId(), m3);
    }

    public List<Message> getAllMessages()
    {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesPaginated(int start, int size)
    {

        List<Message> messages = new ArrayList<>(MessageService.messages.values());
        if(start + size > messages.size())
        {
            return new ArrayList<Message>();
        }
        return messages.subList(start, start+size);
    }

    public List<Message> getAllMessagesForYear(int year)
    {
        Calendar calendar = Calendar.getInstance();
        List<Message> list = messages.values().stream().filter(message -> {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year)
            {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        return list;
    }


    public Message getMessage(int id)
    {
        return messages.get(id);
    }


    public Message removeMessage(int id)
    {
        return messages.remove(id);
    }

    public Message addMessage(Message message)
    {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message)
    {
        if(message.getId() <= 0)
            return null;
        messages.put(message.getId(), message);
        return message;
    }


}
