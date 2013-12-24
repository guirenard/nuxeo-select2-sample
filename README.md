nuxeo-select2-sample
======================

Example of custom nuxeo select2 integration.

In this bundle, we create a new document type called "Album". This document has a multiple document suggestion widget in edit mode. This widget suggests all "Picture" documents stored in your Nuxeo instance.

The display of the selected/suggested documents is customized thanks to a special javascript forrmatter. This formatter diplays a thumbnail of each document in the suggestion box. A click of on the thumbnail displays a bigger version of the picture within a fancybox.

Finally, the formatter also adds a small icon link which opens a fancybox containing an iframe pointing to anoter JSF page. The uid of the document is passed as a request parameter to a backing bean and it allows to easily present information about the document within an xhtml template.
