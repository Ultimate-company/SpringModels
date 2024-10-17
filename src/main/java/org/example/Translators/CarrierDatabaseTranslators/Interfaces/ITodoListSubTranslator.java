package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Todo;
import org.example.Models.ResponseModels.Response;

import java.util.List;

public interface ITodoListSubTranslator {
    /**
     * Retrieves all to-do items.
     *
     * @return A list of to-do items.
     */
    Response<List<Todo>> getItems();

    /**
     * Adds a new to-do item.
     *
     * @param todo The model containing the task to add.
     * @return The ID of the added to-do item.
     */
    Response<Long> addTodo(Todo todo);

    /**
     * Deletes a to-do item by its ID.
     *
     * @param toDoId The ID of the to-do item to delete.
     * @return True if the deletion was successful, otherwise false.
     */
    Response<Boolean> deleteTodo(long toDoId);

    /**
     * Toggles the completion status of a to-do item by its ID.
     *
     * @param toDoId The ID of the to-do item to toggle.
     * @return True if the toggling was successful, otherwise false.
     */
    Response<Boolean> toggleTodo(long toDoId);
}
