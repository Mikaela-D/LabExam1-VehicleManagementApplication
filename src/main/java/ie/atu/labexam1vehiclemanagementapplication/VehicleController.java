package ie.atu.labexam1vehiclemanagementapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/getVehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<List<Vehicle>> addVehicle(@RequestBody Vehicle vehicle) {
        List<Vehicle> updatedVehicleList = vehicleService.add(vehicle);
        return ResponseEntity.ok(updatedVehicleList);
    }

    @PutMapping("/updateVehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updatedVehicle) {
        Vehicle updated = vehicleService.updateVehicle(id, updatedVehicle);
        if (updated != null) {
            return new ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
