package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.Address;
import org.example.Models.ResponseModels.Response;

public interface IAddressSubTranslator {
    /**
     * Toggles the status of an address by its ID.
     *
     * @param id The ID of the address to toggle.
     * @return A response indicating the success or failure of the operation.
     */
    Response<Boolean> toggleAddress(long id);

    /**
     * Retrieves an address by its ID.
     *
     * @param id The ID of the address to retrieve.
     * @return A response containing the address information.
     */
    Response<Address> getAddressById(long id) throws Exception;

    /**
     * Inserts a new address.
     *
     * @param address The address to insert.
     * @return A response containing the ID of the inserted address.
     */
    Response<Long> insertAddress(Address address);

    /**
     * Updates an existing address.
     *
     * @param address The address with updated information.
     * @return A response indicating the success or failure of the operation.
     */
    Response<Long> updateAddress(Address address);

    /**
     * Retrieves an address by user ID.
     *
     * @param id The ID of the user.
     * @return A response containing the address information.
     */
    Response<Address> getAddressByUserId(long id);
}
