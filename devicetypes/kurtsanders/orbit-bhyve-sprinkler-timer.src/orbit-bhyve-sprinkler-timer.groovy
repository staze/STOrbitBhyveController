/*
*  Name:	Orbit B•Hyve™ Sprinler Timer
*  Author: Kurt Sanders
*  Email:	Kurt@KurtSanders.com
*  Date:	3/2019
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*/
def version() { return ["V2.03", "Requires Bhyve Orbit Timer Controller"] }
// End Version Information

import groovy.time.*
import java.text.SimpleDateFormat;

String getAppImg(imgName) 		{ return "https://raw.githubusercontent.com/KurtSanders/STOrbitBhyveTimer/master/images/$imgName" }

metadata {
    definition (name: "Orbit Bhyve Sprinkler Timer", namespace: "kurtsanders", author: "kurt@kurtsanders.com") {
        capability "Refresh"

        attribute "is_connected", "enum", ['Online','Offline']
        attribute "firmware_version", "string"
        attribute "hardware_version", "string"
        attribute "schedulerFreq", "string"
        attribute "lastupdate", "string"
        attribute "statusText", "string"
        attribute "lastSTupdate", "string"
        attribute "name","string"
        attribute "sprinkler_type", "string"
        attribute "next_start_time", "string"
        attribute "next_start_programs", "string"
        attribute "runmode","string"
        attribute "next_start_time", "string"
        attribute "next_start_programs", "string"
        attribute "start_times", "string"
        attribute "rain_icon", "string"
        attribute "presetRuntime", "number"
        attribute "updown", "number"
        attribute "water_volume_gal", "number"

    }

}

def refresh() {
    Date now = new Date()
    def timeString = now.format("EEE MMM dd h:mm:ss a", location.timeZone)
    log.info "Manual Refresh Requested from Orbit B•Hyve™ Timer Device, sending refresh() request to parent smartApp"
    sendEvent(name: "lastSTupdate", value: "Cloud Refresh Requested at\n${timeString}...", "displayed":false)
    sendEvent(name: "banner", value: "Cloud Refresh Requested..", "displayed":false)
    parent.refresh()
}
