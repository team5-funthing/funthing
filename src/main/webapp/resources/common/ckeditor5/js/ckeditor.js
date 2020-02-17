
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
		height: 500,
		
		
	} )
	.then( editor => {
		window.editor = editor;
		
		
	} )
	.catch( error => {
		console.error( error );
	} );
