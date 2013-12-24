function myPictureFormatter(picture) {
  var markup = "<table><tbody>";
  markup += "<tr><td style='padding:5px;'>";
  var views = picture.properties['picture:views'];
  var thumbnailUrl;
  var mediumUrl;
  if (views) {
    for (var i = 0; i < views.length; i++) {
      if (views[i].tag) {
        if (views[i].tag === 'thumb') {
          thumbnailUrl = window.nxContextPath + "/site/automation/" + views[i].content.data;
        } else if (views[i].tag === 'medium') {
          mediumUrl =  window.nxContextPath + "/site/automation/" + views[i].content.data;
        }

      }
    }
  }
  if (thumbnailUrl) {
    markup += "<a class='myCssClass' href='" + mediumUrl + "'><img src='" + thumbnailUrl + "'/></a>"
  }
  markup += "</td><td style='padding:5px;'>";
  markup +=  picture.title;
  var docUrl = picture.contextParameters['documentURL'];
  markup += "<a href='" + window.nxContextPath + "/nxpath/" + picture.repository + "@select2Preview?docId=" + picture.uid + "' class='myCssClass2'><img src='" + window.nxContextPath + "/icons/preview.png' style='margin-left:5px;'></a>";
  if (picture.path) {
    markup += "<span class='displayB detail' style='word-break:break-all;'>" + picture.path + "</span>";
  }
  markup += "</td></tr></tbody></table>";
  return markup;
}
