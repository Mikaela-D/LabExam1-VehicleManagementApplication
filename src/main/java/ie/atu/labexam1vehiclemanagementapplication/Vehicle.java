package ie.atu.labexam1vehiclemanagementapplication;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @NotBlank(message = "Vehicle name must not be empty")
    private String vehicleName;

    @NotBlank(message = "Vehicle type must not be empty")
    private String vehicleType;

    private String registrationNumber;

    @Positive(message = "Price must be a positive number")
    private Integer price;

    @Size(min = 1886, max = 2024, message = "The year of manufacture must be between 1886 and 2024")
    private Integer yearOfManufacture;

    @PositiveOrZero(message = "Mileage cannot be less than 0")
    private Integer Mileage;
}
