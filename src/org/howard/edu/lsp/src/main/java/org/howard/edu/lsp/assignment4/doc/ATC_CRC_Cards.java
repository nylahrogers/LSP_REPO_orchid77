package org.howard.edu.lsp.assignment4.doc;

public class ATC_CRC_Cards {

    /*
    CRC Card
    Class: Aircraft

    Responsibilities:
    - Maintain aircraft identification and type
    - Store current flight information (altitude, speed, location)
    - Update aircraft data when new flight data is received
    - Provide aircraft information to other system components

    Collaborators (if any):
    - FlightDataPacket
    - AircraftDatabase

    Assumptions (if any):
    - Each aircraft continuously transmits flight data through its transponder.
    */


    /*
    CRC Card
    Class: Transponder

    Responsibilities:
    - Broadcast aircraft type and flight data
    - Package aircraft information into high-density packets
    - Transmit flight data packets to the ATC ground station

    Collaborators (if any):
    - Aircraft
    - FlightDataPacket
    - ATCGroundStation

    Assumptions (if any):
    - Every aircraft approaching the airport has an operational transponder.
    */


    /*
    CRC Card
    Class: FlightDataPacket

    Responsibilities:
    - Store encoded aircraft flight information
    - Transfer aircraft data between system components
    - Provide decoded flight information when requested

    Collaborators (if any):
    - Transponder
    - ATCGroundStation
    - AircraftDatabase

    Assumptions (if any):
    - Packets contain aircraft ID, aircraft type, speed, altitude, and position.
    */


    /*
    CRC Card
    Class: ATCGroundStation

    Responsibilities:
    - Receive incoming flight data packets from aircraft transponders
    - Unpack high-density packet data
    - Convert packet data into usable aircraft information
    - Send decoded aircraft information to the aircraft database

    Collaborators (if any):
    - FlightDataPacket
    - AircraftDatabase

    Assumptions (if any):
    - The ground station continuously processes packets from arriving aircraft.
    */


    /*
    CRC Card
    Class: AircraftDatabase

    Responsibilities:
    - Store aircraft flight data records
    - Update aircraft information when new packets arrive
    - Provide aircraft data to other system components
    - Respond to aircraft information queries

    Collaborators (if any):
    - ATCGroundStation
    - Aircraft
    - DisplaySystem
    - DangerDetectionSystem
    - ControllerInterface

    Assumptions (if any):
    - The database stores records for all aircraft currently in monitored airspace.
    */


    /*
    CRC Card
    Class: DisplaySystem

    Responsibilities:
    - Retrieve aircraft information from the database
    - Generate graphical display of aircraft positions
    - Update the display every 10 seconds
    - Present aircraft identifiers and positions to the controller

    Collaborators (if any):
    - AircraftDatabase

    Assumptions (if any):
    - The display refresh occurs automatically every 10 seconds.
    */


    /*
    CRC Card
    Class: DangerDetectionSystem

    Responsibilities:
    - Analyze aircraft flight data for unsafe conditions
    - Detect potential collisions or dangerous proximity
    - Monitor aircraft altitude and distance
    - Notify the controller when dangerous situations occur

    Collaborators (if any):
    - AircraftDatabase
    - Aircraft

    Assumptions (if any):
    - Dangerous situations include aircraft flying too close together.
    */


    /*
    CRC Card
    Class: ControllerInterface

    Responsibilities:
    - Allow the controller to interact with the ATC system
    - Enable the controller to query aircraft information
    - Retrieve aircraft data from the database
    - Display detailed aircraft information upon request

    Collaborators (if any):
    - AircraftDatabase
    - DisplaySystem

    Assumptions (if any):
    - The controller can select an aircraft on the display to view details.
    */

}
