module RMBBank {
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	exports bankapp.component to com.fasterxml.jackson.databind;
}