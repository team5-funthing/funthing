
var funThingEditor;

ClassicEditor
	.create( document.querySelector( '#editor' ), {

		
		toolbar: {
			items: [
				'heading',
				'|',
				'bold',
				'italic',
				'bulletedList',
				'numberedList',
				'alignment',
				'|',
				'indent',
				'outdent',
				'|',
				'CKFinder',
				'imageUpload',
				'blockQuote',
				'mediaEmbed',
				'link',
				'undo',
				'redo'
			]
		},
		language: 'ko',
		image: {
			toolbar: [
				'imageTextAlternative',
				'imageStyle:full',
				'imageStyle:side'
			]
		},
		licenseKey: '',
		
	} )
	.then( editor => {
		window.editor = editor;
		
//		editoro = editor;??
		
		// editor.plugins.get("FileRepository").createUploadAdapter = function (loader){
			
		// 	return new CustomUploadAdapter(loader, "C:/funthing/test", function(result) {
				
		// 		var fileSeq = isEmpty(result[0]) ? "noimage" : result[0];
		// 		var imageUrl = window.location.protocol + "//" + window.location.host + "/test/" + fileSeq;
		// 		console.log("imageUrl : " + imageUrl);
		// 		return {"default" : imageUrl};
				
		// 	});
			
		// };
		
	})
	.catch( error => {
		console.error( error );
	} );






