var imagebtn = document.querySelector(".forimage");
var imagesubmit = document.querySelector(".imagesubmit");
var locationbtn = document.querySelector(".forlocation");
var getlocation = document.querySelector(".getlocation");

imagebtn.addEventListener("click", function() {
    imagesubmit.style.display = "block";
});

locationbtn.addEventListener("click", function(){
    if(navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
      } else {
          alert("Sorry, your browser does not support HTML5 geolocation.");
      }
  });

function successCallback(position) {
    document.getElementById("longitude").value=position.coords.longitude;
    document.getElementById("latitude").value=position.coords.latitude;
    document.querySelector(".forlocation").innerHTML = "Location Found";
}
function errorCallback(error) {
  if(error.code == 1) {
             alert("You've decided not to share your position, but it's OK. We won't ask you again.");
          } else if(error.code == 2) {
              alert("The network is down or the positioning service can't be reached.");
          } else if(error.code == 3) {
              alert("The attempt timed out before it could get the location data.");
          } else {
              alert("Geolocation failed due to unknown error.");
          }
 }
