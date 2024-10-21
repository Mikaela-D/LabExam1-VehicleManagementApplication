package ie.atu.labexam1vehiclemanagementapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicleRepository.findAll();
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
        if(existingVehicle.isPresent()) {
            Vehicle vehicleToUpdate = existingVehicle.get();
            vehicleToUpdate.setVehicleName(updatedVehicle.getVehicleName());
            vehicleToUpdate.setVehicleType(updatedVehicle.getVehicleType());
            vehicleToUpdate.setPrice(updatedVehicle.getPrice());
            updatedVehicle.setYearOfManufacture(updatedVehicle.getYearOfManufacture());
            vehicleToUpdate.setMileage(updatedVehicle.getMileage());

            return vehicleRepository.save(vehicleToUpdate);
        }
        return null;
    }
}
