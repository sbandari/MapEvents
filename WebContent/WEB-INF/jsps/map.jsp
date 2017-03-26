<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Map Events</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/leaflet.css" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/resources/bootstrap.css'>
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/leaflet.js"></script>
<script
	src="https://www.mapquestapi.com/sdk/leaflet/v2.2/mq-map.js?key=73pEhQkNAwscaLmVleQ6oZuJedwAVeGo"></script>
<script
	src="https://www.mapquestapi.com/sdk/leaflet/v2.2/mq-geocoding.js?key=73pEhQkNAwscaLmVleQ6oZuJedwAVeGo"></script>

<script type="text/javascript">
	window.onload = function() {

		var map = L.map('map', {
			layers : MQ.mapLayer()
		}).locate({
			setView : true,
			maxZoom : 15
		});

		/* <c:forEach items="${events}" var="event">
		L
				.marker([ '${event.latitude}', '${event.longitude}' ])
				.addTo(map)
				.bindPopup(
						'<h2>'
								+ "${event.name}"
								+ ' </h2><a href="${pageContext.request.contextPath}/Register/'+"${event.eventId}"+'">Register</a>')
				.openPopup();

		</c:forEach> */

		<c:forEach items="${events}" var="event">
		L.marker([ '${event.latitude}', '${event.longitude}' ]).addTo(map)
				.bindPopup(
						'<button class="btn btn-default" onClick="check('
								+ "${event.eventId}" + ')">Register</button>')
				.openPopup();

		</c:forEach>
	}
	function check(eventId) {
		var userid="<%=session.getAttribute("userid")%>"
	alert(userid);
		<c:forEach items="${events}" var="event">

		if ("${event.eventId}" == eventId) {
			//alert("${event.name}");
			$('#myModal').modal('show');
			window.rEventid="${event.eventId}"
			alert(rEventid);
			$('.registerLink').attr('href','${pageContext.request.contextPath}/user/register/'+"${event.eventId}"+'/'+userid+'/');
			$('.address').empty();
			$('.address').append("${event.name}");
			
		}
		</c:forEach>
	}

</script>
</head>
<body>
	Session
	<%=session.getAttribute("userid")%>
	<h1>Here is the map</h1>
	<div id="map"
		class="leaflet-container leaflet-fade-anim leaflet-grab leaflet-touch-drag"
		style="width: 600px; height: 400px; position: relative;" tabindex="0"></div>
	<%-- <script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/leaf-demo.js"></script> --%>
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<div class="EventContent address"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<a class="registerLink" href=""><button type="button" class="btn btn-default register" >Register</button>
				</a></div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>

