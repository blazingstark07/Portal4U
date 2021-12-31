var pingList = document.querySelectorAll('.ping');
var pingValue = [].map.call(document.querySelectorAll('.ping a'), function(a) {
    return Number(a.textContent);
});

console.log(pingValue);

for(var i = 0; i < pingValue.length; i++) {
    if(pingValue[i] >= 80) {
        pingList[i].style.backgroundColor = 'red';
    }
    else if(pingValue[i] < 80 && pingValue[i] >= 50) {
        pingList[i].style.backgroundColor = 'orange';
    }
    else {
        pingList[i].style.backgroundColor = 'green';
    }
}