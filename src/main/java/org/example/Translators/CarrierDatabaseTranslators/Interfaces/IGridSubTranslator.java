package org.example.Translators.CarrierDatabaseTranslators.Interfaces;

import org.example.Models.CommunicationModels.CarrierModels.UserGridPreference;
import org.example.Models.RequestModels.ApiRequestModels.GridPreferenceRequestModel;
import org.example.Models.ResponseModels.Response;

/**
 * @summary Interface for managing user-specific grid preferences such as visibility, density, and rows per page.
 * Provides methods for updating and retrieving preferences to customize the grid view for each user.
 */
public interface IGridSubTranslator {

    /**
     * @summary Updates the visibility settings for the grid columns for a specific user and grid.
     * @param gridPreferenceRequestModel Contains the visibility model data and user/grid identifiers.
     * @return Response containing a boolean indicating whether the update was successful.
     */
    Response<Boolean> updateGridVisibilityPreference(GridPreferenceRequestModel gridPreferenceRequestModel);

    /**
     * @summary Updates both the grid density and visibility settings for a specified user and grid.
     * @param gridPreferenceRequestModel Contains density and visibility data, along with user/grid identifiers.
     * @return Response containing a boolean indicating whether the update was successful.
     */
    Response<Boolean> updateGridDensityVisibilityPreference(GridPreferenceRequestModel gridPreferenceRequestModel);

    /**
     * @summary Updates the number of rows per page in the grid view for a specific user and grid.
     * @param gridPreferenceRequestModel Contains the new rows-per-page setting, as well as user/grid identifiers.
     * @return Response containing a boolean indicating whether the update was successful.
     */
    Response<Boolean> updateRowsPerPagePreference(GridPreferenceRequestModel gridPreferenceRequestModel);

    /**
     * @summary Retrieves the visibility preferences for a grid, specific to a user and grid ID.
     * @param gridId The ID of the grid associated with the preferences.
     * @return Response containing the UserGridPreference object with the current settings, or null if not found.
     */
    Response<UserGridPreference> getGridVisibilityPreference(int gridId);
}