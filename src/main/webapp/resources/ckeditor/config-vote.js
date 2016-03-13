/**
 * Created by Carbon.Yrs on 2015/11/3.
 */

CKEDITOR.editorConfig = function(config) {

	config.height = 450;
	config.toolbar = [ {
		name : 'document',
		items : [ 'Source', '-', 'NewPage', 'Preview', 'Print' ]
	}, {
		name : 'clipboard',
		items : [ 'Cut', 'Copy', 'Paste', 'PasteText', '-', 'Undo', 'Redo' ]
	}, {
		name : 'editing',
		items : [ 'Find', 'Replace', '-', 'SelectAll' ]
	}, {
		name : 'styles',
		items : [ 'Styles', 'Format', 'Font', 'FontSize' ]
	}, {
		name : 'forms',
		items : [ 'Checkbox', 'Radio', 'Select' ]
	} ];
};
